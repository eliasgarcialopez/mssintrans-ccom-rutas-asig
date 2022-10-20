package mx.gob.imss.mssistrans.ccom.rutas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SINTRANST_MODULO_AMBULANCIA")
@Getter
@Setter
public class ModuloAmbulancia extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODULO_AMBULANCIA")
    private Integer idModulo;

    @Basic
    @Column(name = "DES_NOMBRE")
    private String desNombre;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MODULO_AMBULANCIA", unique = false, nullable = true)
    private ZonaAtencion zona;

    @Basic
    @Column(name = "CVE_PRESUPUESTAL")
    private String cvePresupuestal;
    @Basic
    @Column(name = "NUM_AMBULANCIAS_ASIGNADAS")
    private Integer numAmbulanciasAsignadas;
    @Basic
    @Column(name = "CVE_MATRICULA_JEFE")
    private String cveMatriculaJefe;
    @Basic
    @Column(name = "NUM_TELEFONO_MODULO")
    private String numTelefono;
    @Basic
    @Column(name = "DES_PLANTA_LAVADO")
    private String desPlantaLavado;
    @Basic
    @Column(name = "ID_OOAD")
    private Integer idOOAD;

    @Basic
    @Column(name = "CVE_MATRICULA")
    private String cveMatricula;

    @Basic
    @Column(name = "DES_TIPO_MODULO")
    private String desTipoModulo;
}
