package mx.gob.imss.mssistrans.ccom.rutas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mssistrans.ccom.rutas.model.AsigRutasEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface AsigRutasRepository extends JpaRepository<AsigRutasEntity, Integer> {

    @Query(value = "SELECT SR.ID_RUTA, SR.NUM_FOLIO_RUTA AS NUM_FOLIO_RUTA, SCR.ID_SOLICITUD AS ID_SOLICITUD, SV.CVE_ECCO AS CVE_ECCO,  "
    		+ " SCR.DES_ESTATUS_ASIGNA AS DES_ESTATUS_ASIGNA, SCR.ID_CONTROL_RUTA AS ID_CONTROL_RUTA, SV.ID_VEHICULO AS ID_VEHICULO"
    		+ " FROM SINTRANST_RUTAS SR"
    		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
    		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
    		+ " WHERE SR.IND_ACTIVO =1 "
    		+ " AND SCR.IND_ACTIVO = 1 "
    		+ " AND SV.IND_ACTIVO =1 "
    		+ " AND SCR.IND_SISTEMA = 1 "
            , countQuery = "SELECT COUNT(SR.ID_RUTA)"
            		+ " FROM SINTRANST_RUTAS SR"
            		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
            		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
            		+ " WHERE SR.IND_ACTIVO =1 "
            		+ " AND SCR.IND_ACTIVO = 1 "
            		+ " AND SV.IND_ACTIVO =1 "
            		+ " AND SCR.IND_SISTEMA = 1 "
            ,nativeQuery = true)
    Page<List<AsigRutasEntity>> consultaGeneral(Pageable page);


    @Query(value = "SELECT SR.ID_RUTA, SR.NUM_FOLIO_RUTA AS NUM_FOLIO_RUTA, SCR.ID_SOLICITUD AS ID_SOLICITUD, SV.CVE_ECCO AS CVE_ECCO"
    		+ " , SCR.DES_ESTATUS_ASIGNA AS DES_ESTATUS_ASIGNA, SCR.ID_CONTROL_RUTA AS ID_CONTROL_RUTA, SV.ID_VEHICULO AS ID_VEHICULO"
    		+ " FROM SINTRANST_RUTAS SR"
    		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
    		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
    		+ " WHERE SCR.IND_ACTIVO  = SR.IND_ACTIVO AND SCR.IND_SISTEMA  = SR.IND_SISTEMA AND"
    		+ " SR.IND_SISTEMA = SV.IND_SISTEMA AND SR.IND_ACTIVO = SV.IND_ACTIVO AND"
    		+ " SCR.IND_ACTIVO = 1 AND SCR.IND_SISTEMA = 1 "
    		+ " AND SR.NUM_FOLIO_RUTA = ? AND SCR.ID_SOLICITUD = ?"
            , countQuery = "SELECT COUNT(SR.ID_RUTA)"
            		+ " FROM SINTRANST_RUTAS SR"
            		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
            		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
            		+ " WHERE SCR.IND_ACTIVO  = SR.IND_ACTIVO AND SCR.IND_SISTEMA  = SR.IND_SISTEMA AND"
            		+ " SR.IND_SISTEMA = SV.IND_SISTEMA AND SR.IND_ACTIVO = SV.IND_ACTIVO AND"
            		+ " SCR.IND_ACTIVO = 1 AND SCR.IND_SISTEMA = 1 "
            + " AND SR.NUM_FOLIO_RUTA = ? AND SCR.ID_SOLICITUD = ?"
            , nativeQuery = true)
    Page<List<AsigRutasEntity>> getConsultaById(String idAsignacion, String idSolicitud, Pageable pageable);

    @Query(value = "SELECT SR.ID_RUTA, SR.NUM_FOLIO_RUTA AS NUM_FOLIO_RUTA, SCR.ID_SOLICITUD AS ID_SOLICITUD, SV.CVE_ECCO AS CVE_ECCO"
    		+ " , SCR.DES_ESTATUS_ASIGNA AS DES_ESTATUS_ASIGNA, SCR.ID_CONTROL_RUTA AS ID_CONTROL_RUTA, SV.ID_VEHICULO AS ID_VEHICULO"
    		+ " FROM SINTRANST_RUTAS SR"
    		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
    		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
    		+ " WHERE SCR.IND_ACTIVO  = SR.IND_ACTIVO AND SCR.IND_SISTEMA  = SR.IND_SISTEMA AND"
    		+ " SR.IND_SISTEMA = SV.IND_SISTEMA AND SR.IND_ACTIVO = SV.IND_ACTIVO AND"
    		+ " SCR.IND_ACTIVO = 1 AND SCR.IND_SISTEMA = 1 "
    		+ " AND SR.ID_RUTA  = ? "
            , countQuery = "SELECT COUNT(SR.ID_RUTA)"
            		+ " FROM SINTRANST_RUTAS SR"
            		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
            		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
            		+ " WHERE SCR.IND_ACTIVO  = SR.IND_ACTIVO AND SCR.IND_SISTEMA  = SR.IND_SISTEMA AND"
            		+ " SR.IND_SISTEMA = SV.IND_SISTEMA AND SR.IND_ACTIVO = SV.IND_ACTIVO AND"
            		+ " SCR.IND_ACTIVO = 1 AND SCR.IND_SISTEMA = 1 "
            + " AND SR.ID_RUTA  = ? "
            , nativeQuery = true)
    Page<List<AsigRutasEntity>> getConsultaByIdAsignacion(String idRuta, Pageable pageable);


    @Query(value = "SELECT SR.ID_RUTA, SR.NUM_FOLIO_RUTA AS NUM_FOLIO_RUTA, SCR.ID_SOLICITUD AS ID_SOLICITUD, SV.CVE_ECCO AS CVE_ECCO"
    		+ " , SCR.DES_ESTATUS_ASIGNA AS DES_ESTATUS_ASIGNA, SCR.ID_CONTROL_RUTA AS ID_CONTROL_RUTA, SV.ID_VEHICULO AS ID_VEHICULO"
    		+ " FROM SINTRANST_RUTAS SR"
    		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
    		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
    		+ " WHERE SR.IND_ACTIVO =1 "
    		+ " AND SCR.IND_ACTIVO = 1 "
    		+ " AND SV.IND_ACTIVO =1 "
    		+ " AND SCR.IND_SISTEMA = 1 "
    		+ " AND SCR.ID_SOLICITUD = ? "
            , countQuery = "SELECT COUNT(SR.ID_RUTA)"
            		+ " FROM SINTRANST_RUTAS SR"
            		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
            		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
            		+ " WHERE SR.IND_ACTIVO =1 "
            		+ " AND SCR.IND_ACTIVO = 1 "
            		+ " AND SV.IND_ACTIVO =1 "
            		+ " AND SCR.IND_SISTEMA = 1 "
            		+ " AND SCR.ID_SOLICITUD = ? "
            , nativeQuery = true)
    Page<List<AsigRutasEntity>> getConsultaByIdSolicitud( String idSolicitud, Pageable pageable);

	@Modifying(flushAutomatically = true)
	@Query(value = "UPDATE SINTRANST_CONTROL_RUTAS SET FEC_BAJA = CURRENT_TIMESTAMP(), IND_ACTIVO = 0"
			+ " WHERE IND_ACTIVO = 1 AND ID_CONTROL_RUTA = ? "
			,nativeQuery = true )
	void delete ( String idControlRuta );
	
    @Query(value = "SELECT SR.ID_RUTA, SR.NUM_FOLIO_RUTA AS NUM_FOLIO_RUTA, SCR.ID_SOLICITUD AS ID_SOLICITUD, SV.CVE_ECCO AS CVE_ECCO"
    		+ " , SCR.DES_ESTATUS_ASIGNA AS DES_ESTATUS_ASIGNA, SCR.ID_CONTROL_RUTA AS ID_CONTROL_RUTA, SV.ID_VEHICULO AS ID_VEHICULO"
    		+ " FROM SINTRANST_RUTAS SR"
    		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
    		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
    		+ " WHERE SR.IND_ACTIVO =1 "
    		+ " AND SCR.IND_ACTIVO = 1 "
    		+ " AND SV.IND_ACTIVO =1 "
    		+ " AND SCR.IND_SISTEMA = 1 "
    		+ " AND SCR.ID_CONTROL_RUTA  = ? "
            , countQuery = "SELECT COUNT(SR.ID_RUTA)"
            		+ " FROM SINTRANST_RUTAS SR"
            		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
            		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
            		+ " WHERE SR.IND_ACTIVO =1 "
            		+ " AND SCR.IND_ACTIVO = 1 "
            		+ " AND SV.IND_ACTIVO =1 "
            		+ " AND SCR.IND_SISTEMA = 1 "
            + " AND SCR.ID_CONTROL_RUTA  = ? "
            , nativeQuery = true)
    Page<List<AsigRutasEntity>> getConsultaByIdControlRuta(String idControlRuta, Pageable pageable);
    
    @Query(value = "SELECT SR.ID_RUTA, SR.NUM_FOLIO_RUTA AS NUM_FOLIO_RUTA, SCR.ID_SOLICITUD AS ID_SOLICITUD, SV.CVE_ECCO AS CVE_ECCO"
    		+ " , SCR.DES_ESTATUS_ASIGNA AS DES_ESTATUS_ASIGNA, SCR.ID_CONTROL_RUTA AS ID_CONTROL_RUTA, SV.ID_VEHICULO AS ID_VEHICULO"
    		+ " FROM SINTRANST_RUTAS SR"
    		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
    		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
    		+ " WHERE SR.IND_ACTIVO =1 "
    		+ " AND SCR.IND_ACTIVO = 1 "
    		+ " AND SV.IND_ACTIVO =1 "
    		+ " AND SCR.IND_SISTEMA = 1 "
    		+ " AND SCR.ID_CONTROL_RUTA  = ? "
    		+ "	AND SCR.ID_SOLICITUD = ? "
            , countQuery = "SELECT COUNT(SR.ID_RUTA)"
            		+ " FROM SINTRANST_RUTAS SR"
            		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
            		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SV.ID_VEHICULO = SCR.ID_VEHICULO"
            		+ " WHERE SR.IND_ACTIVO =1 "
            		+ " AND SCR.IND_ACTIVO = 1 "
            		+ " AND SV.IND_ACTIVO =1 "
            		+ " AND SCR.IND_SISTEMA = 1 "
            + " AND SCR.ID_CONTROL_RUTA  = ? "
            + "	AND SCR.ID_SOLICITUD = ? "
            , nativeQuery = true)
    Page<List<AsigRutasEntity>> getConsultaByIdControlRutaAndIdSolicitud(String idAsignacion, String idControlRuta, Pageable pageable);
	
}
