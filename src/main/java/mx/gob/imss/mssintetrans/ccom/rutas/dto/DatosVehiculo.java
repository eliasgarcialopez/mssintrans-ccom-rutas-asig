package mx.gob.imss.mssintetrans.ccom.rutas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "datosVehiculo")
public class DatosVehiculo {
	
	@JsonProperty
	private String idVehiculo;
	
	@JsonProperty
	private String cveEcco;
	
	@JsonProperty
	private String desMarca;
	
	@JsonProperty
	private String desTipo;
	
	@JsonProperty
	private String numPlacas;
	
	@JsonProperty
	private String desModelo;
	
	@JsonProperty
	private String nomModulo;

}
