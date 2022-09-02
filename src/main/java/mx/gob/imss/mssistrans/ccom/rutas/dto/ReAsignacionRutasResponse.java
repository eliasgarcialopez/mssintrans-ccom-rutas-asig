package mx.gob.imss.mssistrans.ccom.rutas.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "ReAsignacionRutas")
public class ReAsignacionRutasResponse {

	@JsonProperty
	private String idReasignacion;
	
	@JsonProperty
	private String idRutaAsignacion;
	
	@JsonProperty
	private String idSolicitud;
	

	@JsonProperty
	private String cveEcco;
	
	@JsonProperty
	private String desEstatusSolicitud;

	
}