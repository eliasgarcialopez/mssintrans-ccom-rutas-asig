package mx.gob.imss.mssistrans.ccom.rutas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mssistrans.ccom.rutas.model.ReasignacionTripulacionEntity;

@Repository
public interface ReasignacionTripulacionRepository extends JpaRepository<ReasignacionTripulacionEntity, Integer> {
	
	    @Query(value = "SELECT SRR.DES_SINIESTRO, SCR.ID_SOLICITUD, SCR.ID_CONTROL_RUTA,SPA.ID_PERSONAL_AMBULANCIA,SC.ID_CHOFER,  SC.NOM_CHOFER, SPA.DES_PUESTO"
	    		+ " , SC.CVE_MATRICULA_CHOFER, SCR.NUM_FOLIO_TJTA_COMBUSTIBLE, SCR.ID_RUTA"
	    		+ " , SRR.DES_MOTIVO_REASIGNACION"
	    		+ " FROM SINTRANST_CONTROL_RUTAS SCR"
	    		+ " INNER JOIN SINTRANST_TRIPULACION ST ON SCR.ID_TRIPULACION = ST.ID_TRIPULACION"
	    		+ " INNER JOIN SINTRANST_PERSONAL_AMBULANCIA SPA ON ST.ID_PERSONAL_AMBULANCIA_CHOFER = SPA.ID_PERSONAL_AMBULANCIA"
	    		+ " INNER JOIN SINTRANST_CHOFERES SC ON SC.ID_CHOFER  = SPA.ID_CHOFER"
	    		+ " LEFT JOIN SINTRANST_REASIGNACION_RUTAS SRR ON (SRR.ID_RUTA = SCR.ID_RUTA AND SRR.ID_CHOFER = ST.ID_PERSONAL_AMBULANCIA_CHOFER AND SRR.ID_VEHICULO = SCR.ID_VEHICULO)"
	    		+ " WHERE SCR.IND_ACTIVO = 1 AND SCR.IND_SISTEMA = 1 "
	    		+ " AND SCR.ID_CONTROL_RUTA = ?"
            ,nativeQuery = true)
	    ReasignacionTripulacionEntity getDatosChofer(Integer idControlRuta);
    

	    @Query(value = "SELECT  SRR.DES_SINIESTRO, SCR.ID_SOLICITUD, SCR.ID_CONTROL_RUTA,SPA.ID_PERSONAL_AMBULANCIA,SC.ID_CHOFER,  SC.NOM_CHOFER, SPA.DES_PUESTO"
	    		+ " , SC.CVE_MATRICULA_CHOFER, SCR.NUM_FOLIO_TJTA_COMBUSTIBLE, SCR.ID_RUTA"
	    		+ " , SRR.DES_MOTIVO_REASIGNACION"
	    		+ " FROM SINTRANST_CONTROL_RUTAS SCR"
	    		+ " INNER JOIN SINTRANST_TRIPULACION ST ON SCR.ID_TRIPULACION = ST.ID_TRIPULACION"
	    		+ " INNER JOIN SINTRANST_PERSONAL_AMBULANCIA SPA ON ST.ID_PERSONAL_AMBULANCIA_CHOFER = SPA.ID_PERSONAL_AMBULANCIA"
	    		+ " INNER JOIN SINTRANST_CHOFERES SC ON SC.ID_CHOFER  = SPA.ID_CHOFER"
	    		+ " LEFT  JOIN SINTRANST_REASIGNACION_RUTAS SRR ON (SRR.ID_RUTA = SCR.ID_RUTA AND SRR.ID_CHOFER = ST.ID_PERSONAL_AMBULANCIA_CHOFER AND SRR.ID_VEHICULO = SCR.ID_VEHICULO)"
	    		+ " WHERE SCR.IND_ACTIVO=1 AND SCR.IND_SISTEMA = 1 "
	    		+ " AND SCR.ID_RUTA = ? AND SCR.ID_SOLICITUD = ? AND SCR.ID_VEHICULO = ?"
            ,nativeQuery = true)
	    ReasignacionTripulacionEntity getDatosChoferByidVehiculo(Integer idRuta, Integer idSolicitud, Integer idVehiculo);
    

}
