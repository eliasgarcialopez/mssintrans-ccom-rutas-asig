package mx.gob.imss.mssistrans.ccom.rutas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mssistrans.ccom.rutas.model.EccoEntity;


@Repository
public interface ReasignacionEccoRepository extends JpaRepository<EccoEntity, Integer> {

    @Query(value = "SELECT SV.ID_VEHICULO, SV.CVE_ECCO, SV.NUM_PLACAS,SCR.ID_RUTA,SCR.ID_SOLICITUD"
    		+ " ,SCR.FEC_INICIO_ASIGNA"
    		+ " FROM SINTRANST_RUTAS SR"
    		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
    		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SCR.ID_VEHICULO = SV.ID_VEHICULO"
    		+ " WHERE SR.IND_ACTIVO = SCR.IND_ACTIVO AND SR.IND_ACTIVO = SV.IND_ACTIVO AND"
    		+ " SR.IND_SISTEMA = SCR.IND_SISTEMA AND SR.IND_SISTEMA = SV.IND_SISTEMA AND"
    		+ " SR.IND_ACTIVO = 1 AND SR.IND_SISTEMA = 1"
    		+ " AND SCR.FEC_INICIO_ASIGNA = CURRENT_DATE()"
            , countQuery = "SELECT COUNT(SV.ID_VEHICULO)"
            		+ " FROM SINTRANST_RUTAS SR"
            		+ " INNER JOIN SINTRANST_CONTROL_RUTAS SCR ON SCR.ID_RUTA = SR.ID_RUTA"
            		+ " INNER JOIN SINTRANST_VEHICULOS SV ON SCR.ID_VEHICULO = SV.ID_VEHICULO"
            		+ " WHERE SR.IND_ACTIVO = SCR.IND_ACTIVO AND SR.IND_ACTIVO = SV.IND_ACTIVO AND"
            		+ " SR.IND_SISTEMA = SCR.IND_SISTEMA AND SR.IND_SISTEMA = SV.IND_SISTEMA AND"
            		+ " SR.IND_ACTIVO = 1 AND SR.IND_SISTEMA = 1"
            		+ " AND SCR.FEC_INICIO_ASIGNA = CURRENT_DATE()"
            ,nativeQuery = true)
    List<EccoEntity> getEcco();

}
