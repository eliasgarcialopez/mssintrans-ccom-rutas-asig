package mx.gob.imss.mssistrans.ccom.rutas.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "ReasignacionEccos")
public class ReasignacionEccoResponse {

	@JsonProperty
	private String idVehiculo;
	
	@JsonProperty
	private String cveEcco;

	@JsonProperty
	private String numPlacas;

	@JsonProperty
	private String idRuta;

	@JsonProperty
	private String IdSolicitud;

	@JsonProperty
	private String IdAsignacion;
}
