package mx.gob.imss.mssistrans.ccom.rutas.repository;

import mx.gob.imss.mssistrans.ccom.rutas.model.ControlRutas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;


public interface ControlRutasForaneasRepository extends JpaRepository<ControlRutas, Integer> {

    /**
     * Recupera una ruta asignada por idRuta
     *
     * @param idArrendadora
     * @param activo
     * @return
     */
    @Query(value = "select CR from ControlRutas CR " +
            "where CR.activo = true " +
            "and CR.indiceSistema = true " +
            "and CR.ruta.indRutaForanea = true " +
            "and CR.idControlRuta = ?1")
    Optional<ControlRutas> findByIdControlRuta(Integer idControlRuta);


    /**
     * Consulta todas las asignaciones por la bandera de activo
     *
     * @param pageable
     * @return
     */
    @Query(value = "select a from ControlRutas a " +
            "where a.activo = true " +
            "and a.indiceSistema = true " +
            "and a.ruta.indRutaForanea = true")
    Page<ControlRutas> findAll(Pageable pageable);


    /**
     * Consulta todas las asignaciones  por la bandera de activo y OOAD
     *
     * @param pageable
     * @return
     */
    @Query(value = "select a from ControlRutas a " +
            "where " +
            " a.modulo.idOOAD=?1 " +
            "and a.activo = true " +
            "and a.indiceSistema = true " +
            "and a.ruta.indRutaForanea = true")
    Page<ControlRutas> findAll(Pageable pageable, Integer idOOAD);

    /**
     * Consulta todos los folios asignados   por la bandera de activo y OOAD
     *
     * @param pageable
     * @return
     */

    @Query(value = "select a.numFolioTarjetaCombustible from ControlRutas a " +
            "where a.modulo.idOOAD = ?1 " +
            "and a.activo = true " +
            "and a.indiceSistema = true " +
            "and a.ruta.indRutaForanea = true")
    ArrayList<String> findTarjetasByOoad(Integer idOoad);

    /**
     * todo - falta filtrar por ruta foranea
     * Busca control de rutas por ecco
     *
     * @param ecco
     * @param idOoad
     * @return
     */
    @Query(value = "select cr from ControlRutas cr join cr.idVehiculo v join v.unidad u "
            + "where v.cveEcco = ?1 and u.ooad.idOoad = ?2 and v.indActivo = 1 "
            + "order by cr.fechaAlta desc")
    ArrayList<ControlRutas> findVehiculoByEcco(String ecco, Integer idOoad);


}
