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
@Table(name = "SINTRANST_TRIPULACION")
public class ReasignacionTripulacionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTROL_RUTA", unique = false, nullable = true)
	private String idControlRuta;
	
	@Column(name = "ID_CHOFER", unique = false, nullable = true)
	private String idChofer;
	
	@Column(name = "NOM_CHOFER", unique = false, nullable = true)
	private String nomTripulante;
	
	@Column(name = "CVE_MATRICULA_CHOFER", unique = false, nullable = true)
	private String cveMatricula;
	
	@Column(name = "NUM_FOLIO_TJTA_COMBUSTIBLE", unique = false, nullable = true)
	private String numTarjetaDig;
	
	@Column(name = "ID_PERSONAL_AMBULANCIA", unique = false, nullable = true)
	private String idPersonalAmbulancia;
	
	@Column(name = "DES_MOTIVO_REASIGNACION", unique = false, nullable = true)
	private String desMotivoReasig;

	@Column(name = "DES_SINIESTRO", unique = false, nullable = true)
	private String desSiniestro;

}

