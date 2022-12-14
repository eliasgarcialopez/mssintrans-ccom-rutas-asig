package mx.gob.imss.mssistrans.ccom.rutas.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "SINTRANST_TRIPULACION")
@Getter
@Setter
public class Tripulacion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRIPULACION")
	private Integer idTripulacion;

	@Basic
	@Column(name = "FEC_FECHA")
	private LocalDate fecFecha;

	@Basic
	@Column(name = "ID_VEHICULO")
	private Integer idVehiculo;

	@Basic
    @OneToOne
	@JoinColumn(name = "ID_PERSONAL_AMBULANCIA_CHOFER")
	private PersonalAmbulancia personalChofer;

	@Basic
    @OneToOne
	@JoinColumn(name = "ID_PERSONAL_AMBULANCIA_C1")
	private PersonalAmbulancia personalCamillero1;

	@Basic
    @OneToOne
	@JoinColumn(name = "ID_PERSONAL_AMBULANCIA_C2")
	private PersonalAmbulancia personalCamillero2;
	
	@Basic
	@Column(name = "FEC_ALTA")
	private LocalDate fechaAlta;
	
	@Basic
	@Column(name = "FEC_ACTUALIZACION")
	private LocalDate fechaActualizacion;
	
	@Basic
	@Column(name = "FEC_BAJA")
	private LocalDate fechaBaja;

	@Basic
	@Column(name = "IND_ACTIVO")
	private boolean activo;
	@Basic
	@Column(name = "IND_SISTEMA")
	private boolean indiceSistema;
}
