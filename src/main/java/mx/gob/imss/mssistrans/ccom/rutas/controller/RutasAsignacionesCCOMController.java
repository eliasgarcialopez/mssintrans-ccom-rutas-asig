package mx.gob.imss.mssistrans.ccom.rutas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import mx.gob.imss.mssistrans.ccom.rutas.dto.DatosUsuarioDTO;
import mx.gob.imss.mssistrans.ccom.rutas.dto.Response;
import mx.gob.imss.mssistrans.ccom.rutas.service.impl.AsigRutasServiceImpl;
import mx.gob.imss.mssistrans.ccom.rutas.util.ValidaDatos;

import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author opimentel
 *
 */
@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
@RestController
@RequestMapping("/RutasAsignacionesCCOM")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class RutasAsignacionesCCOMController {

	@Autowired
	AsigRutasServiceImpl asigRutasServiceImpl;
	
	@GetMapping(path = "/consultaVistaRapida")
	public <T> ResponseEntity<Response> consultaById(@RequestParam Integer pagina,
			@RequestParam(defaultValue = "10") Integer tamanio, @RequestParam String idRutaAsig,
			@RequestParam String idSolicitud, @RequestParam(defaultValue = "asc") String orden,
			@RequestParam(defaultValue = "idEstatusSolicitud") String ordenCol) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Pageable pageable = PageRequest.of(pagina, tamanio);
			Response response = asigRutasServiceImpl.consultaVistaRapida(pagina, tamanio, idRutaAsig, idSolicitud);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@DeleteMapping(path = "{idRutaAsignacion}")
	public <T> ResponseEntity<Response> delete(@PathVariable String idRutaAsignacion) {
		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = asigRutasServiceImpl.delete(idRutaAsignacion);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	/****** HU006 - 26 **********/
	@GetMapping(path = "/getRutas")
	public <T> ResponseEntity<Response> obtenerRuta() {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			DatosUsuarioDTO datosUsuarios = ValidaDatos.datosUsuarios();
			Response response = asigRutasServiceImpl.getRutas(datosUsuarios.getIDOOAD());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/getSolTraslado/{idVehiculo}")
	public <T> ResponseEntity<Response> getSolicitudTraslado(@PathVariable Integer idVehiculo) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			DatosUsuarioDTO datosUsuarios = ValidaDatos.datosUsuarios();
			Response response = asigRutasServiceImpl.getSolicitudTraslado(datosUsuarios.getIdUnidadAdscripcion(),
					idVehiculo);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/getDatosAsignacion")
	public <T> ResponseEntity<Response> getDatosAsignacion(@RequestParam Integer idVehiculo,
			@RequestParam Integer idRuta, @RequestParam Integer idSolicitud) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			DatosUsuarioDTO datosUsuarios = ValidaDatos.datosUsuarios();
			Response response = asigRutasServiceImpl.getDatosAsignacion(idVehiculo, idRuta, idSolicitud);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/getTripulacionAsignada")
	public <T> ResponseEntity<Response> getTripulacionAsignada(@RequestParam Integer idVehiculo,
			@RequestParam Integer idRuta, @RequestParam Integer idSolicitud) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = asigRutasServiceImpl.getTripulacionAsignada(idRuta, idVehiculo, idSolicitud);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/getRegRecorrido")
	public <T> ResponseEntity<Response> getRegRecorrido(@RequestParam Integer idVehiculo,
			@RequestParam Integer idRuta) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = asigRutasServiceImpl.getRegistroRecorrido(idVehiculo, idRuta);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@PutMapping(path = "{idVehiculo}")
	public <T> ResponseEntity<Response> update(@PathVariable String idVehiculo, @RequestParam String idNuevoVehiculo,
			@RequestParam String idRuta, @RequestParam String idNuevaRuta, @RequestParam String idSolicitud,
			@RequestParam String idNuevaSolicitud, @RequestParam String desEstatus) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = asigRutasServiceImpl.update(idVehiculo, idNuevoVehiculo, idRuta, idNuevaRuta,
					idSolicitud, idNuevaSolicitud, desEstatus);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

}
