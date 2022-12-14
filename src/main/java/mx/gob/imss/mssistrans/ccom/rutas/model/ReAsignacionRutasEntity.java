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
public class ReAsignacionRutasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTROL_RUTA", unique = false, nullable = true)
	private String idControlRuta;
	
	@Column(name = "ID_SOLICITUD", unique = false, nullable = true)
	private String idSolicitud;

	@Column(name = "NUM_FOLIO_RUTA", unique = false, nullable = true)
	private String idRutaAsignacion;
	
	@Column(name = "CVE_ECCO", unique = false, nullable = true)
	private String cveEcco;

	@Column(name = "DES_ESTATUS_ASIGNA", unique = false, nullable = true)
	private String desEstatusSolicitud;

	@Column(name = "ID_VEHICULO", unique = false, nullable = true)
	private String idVehiculo;
	
	@Column(name = "ID_RUTA", unique = false, nullable = true)
	private String idRuta;
	
	
	
	
}

