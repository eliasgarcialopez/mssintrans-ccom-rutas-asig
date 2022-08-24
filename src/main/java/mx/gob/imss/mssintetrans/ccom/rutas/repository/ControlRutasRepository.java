package mx.gob.imss.mssintetrans.ccom.rutas.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mssintetrans.ccom.rutas.model.ControlRutas;


@Repository
public interface ControlRutasRepository extends JpaRepository<ControlRutas, Integer> {
	
	   /**
     * Recupera una ruta asignada por idRuta
     *
     * @param idArrendadora
     * @param activo
     * @return
     */
	@Query(value = "SELECT CR FROM ControlRutas CR "
			+ "WHERE CR.activo = true and CR.indiceSistema = true"
			+ " AND  CR.idControlRuta = ?1"
			)
	Optional<ControlRutas> findByIdControlRuta(Integer idControlRuta);
	
	
	   /**
     * Consulta todas las asignaciones por la bandera de activo
     *
     *
     * @param pageable
     * @return
     */
    @Query(value = "select a from ControlRutas a " +
            "where " +
                  "a.activo = true")
    Page<ControlRutas> findAll(Pageable pageable);
    
    
    /**
     * Consulta todas las asignaciones  por la bandera de activo y OOAD
     *
     *
     * @param pageable
     * @return
     */
    @Query(value = "select a from ControlRutas a " +
            "where " +
    		" a.modulo.idOOAD=?1 and "+    
                  "a.activo = true")
    Page<ControlRutas> findAll(Pageable pageable, Integer idOOAD);
    
    /**
     * Consulta todos los folios asignados   por la bandera de activo y OOAD
     *
     *
     * @param pageable
     * @return
     */
    
	@Query(value = "select a.numFolioTarjetaCombustible from ControlRutas a "
	        +  "where a.modulo.idOOAD = ?1 and a.activo = true ")
	ArrayList<String> findTarjetasByOoad(Integer idOoad);
	
	
	

	
}
