package mx.gob.imss.mssistrans.ccom.rutas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SINTRANST_REASIGNACION_RUTAS")
public class ReAsigRutasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REASIGNACION", unique = false, nullable = true)
	private String idReasignacion;
	@Column(name = "ID_RUTA", unique = false, nullable = true)
	private String idruta;
	@Column(name = "ID_CHOFER", unique = false, nullable = true)
	private String idChofer;
	@Column(name = "ID_VEHICULO", unique = false, nullable = true)
	private String idVehiculo;
	@Column(name = "DES_MOTIVO_REASIGNACION", unique = false, nullable = true)
	private String desMotivoReasig;
	@Column(name = "DES_SINIESTRO", unique = false, nullable = true)
	private String desSiniestro;
	@Column(name = "ID_VEHICULO_SUST", unique = false, nullable = true)
	private String idVehiculoSust;
	@Column(name = "ID_CHOFER_SUST", unique = false, nullable = true)
	private String idChoferSust;
	@Column(name = "ID_ASIGNACION", unique = false, nullable = true)
	private String idAsignacion;
	@Column(name = "CVE_MATRICULA", unique = false, nullable = true)
	private String cveMatricula;
	@Column(name = "FEC_ALTA", unique = false, nullable = true)
	private String fecAlta;
	@Column(name = "FEC_ACTUALIZACION", unique = false, nullable = true)
	private String fecActualizacion;
	@Column(name = "FEC_BAJA", unique = false, nullable = true)
	private String fecBaja;
	@Column(name = "IND_ACTIVO", unique = false, nullable = true)
	private String indActivo;
	@Column(name = "IND_SISTEMA", unique = false, nullable = true)
	private String indSistema;
	
	
}

