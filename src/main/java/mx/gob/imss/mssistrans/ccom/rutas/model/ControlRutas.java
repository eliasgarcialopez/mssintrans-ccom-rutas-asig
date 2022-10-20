package mx.gob.imss.mssistrans.ccom.rutas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "SINTRANST_CONTROL_RUTAS")
@Getter
@Setter
public class ControlRutas extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTROL_RUTA")
    private Integer idControlRuta;

    @OneToOne
    @JoinColumn(name = "ID_SOLICITUD")
    private SolicitudTraslado idSolcitud;

    @OneToOne
    @JoinColumn(name = "ID_VEHICULO")
    private Vehiculos vehiculo;

    @Basic
    @Column(name = "DES_ESTATUS_ASIGNA")
    private String desEstatusAsigna;

    @OneToOne
    @JoinColumn(name = "ID_TRIPULACION", unique = false, nullable = true)
    private Tripulacion tripulacion;

    @Basic
    @Column(name = "NUM_FOLIO_TJTA_COMBUSTIBLE")
    private String numFolioTarjetaCombustible;

    @Basic
    @Column(name = "FEC_INICIO_ASIGNA")
    private LocalDate fechaInicioAsigna;

    @Basic
    @Column(name = "TIM_INICIO_ASIGNA")
    private LocalTime timInicioAsigna;

    @OneToOne
    @JoinColumn(name = "ID_RUTA", unique = false, nullable = true)
    private Rutas ruta;

    @OneToOne
    @JoinColumn(name = "ID_MODULO_AMBULANCIA", unique = false, nullable = true)
    private ModuloAmbulancia modulo;

    @Column(name = "DES_TIPO_INCIDENTE")
    private String desTipoIncidente;

}
