package mx.gob.imss.mssistrans.ccom.rutas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ControlRutasForaneasRequest {
	    private Integer idSolicitudTraslado;
	    private Integer idModulo;
	    private String numFolioTarjeta;
	    private Integer idTripulacion;	 
	    private Integer idVehiculo;	
	    private String fechaRuta;
	    private Integer turno;
	    private String horaRuta;
	    private String cveMatricula;
		private String viaticosChofer;
		private String viaticosCamillero1;
		private String viaticosCamillero2;
		private String viaticosCaseta;
	   }
