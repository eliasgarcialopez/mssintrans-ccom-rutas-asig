package mx.gob.imss.mssistrans.ccom.rutas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "SINTRANST_BITACORA_SERVICIOS")
public class BitacoraServiciosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BITACORA")
    private Integer idBitacora;
	
	@Column(name = "NUM_BITACORA")
	private String numBitacora;
	
	@Column(name = "FEC_BITACORA")
	private Date fecBitacora;
	
	@Column(name="ID_OOAD")
	private Integer idOoad;
	
	@Column(name = "ID_PRESTAMO")
	private Integer idPrestamo;
	
	@OneToOne
	@JoinColumn(name = "ID_ASIGNACION")
	private ControlRutas controlRuta;
	
	@Column(name = "CVE_MATRICULA")
	private String matricula;
	
	@Column(name = "FEC_ALTA")
	private Date fechaAlta;
	 
	@Column(name = "FEC_ACTUALIZACION")
	private Date fechaActualizacion;

	@Column(name = "FEC_BAJA")
	private Date fechaBaja;

	@Column(name = "IND_ACTIVO")
	private Boolean indActivo;

	@Column(name = "IND_SISTEMA")
	private Boolean indSistema;

}
