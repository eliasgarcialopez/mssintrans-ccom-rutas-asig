package mx.gob.imss.mssistrans.ccom.rutas.service;

import mx.gob.imss.mssistrans.ccom.rutas.dto.Response;

@SuppressWarnings("rawtypes")
public interface AsigRutasService {

	<T>Response<?> consultaVistaRapida (Integer pagina, Integer tamanio, String idAsignacion, String idSolicitud);
	Response delete ( String id );
	
	
	<T>Response getRutas(Integer idOoad);
	<T>Response getSolicitudTraslado(Integer idUnidadAdscripcion, Integer idVehiculo);
	<T>Response getDatosAsignacion(Integer idVehiculo, Integer idRuta, Integer idSolicitud);
	<T>Response getTripulacionAsignada(Integer idRuta, Integer idVehiculo, Integer idSolicitud);
	<T>Response getRegistroRecorrido(Integer idVehiculo, Integer idRuta);
	<T>Response update(String idVehiculo, String idNuevoVehiculo, String idRuta, String idNuevaRuta, String idSolicitud, String idNuevaSolicitud, String desEstatus);
	
 /* 
	<T>Response generaPDF (Integer idOoad, Integer idUnidad, Integer idArrendatario);
	<T>Response save ( VehiculosCromaticaResponse vehiculo );*/
}
