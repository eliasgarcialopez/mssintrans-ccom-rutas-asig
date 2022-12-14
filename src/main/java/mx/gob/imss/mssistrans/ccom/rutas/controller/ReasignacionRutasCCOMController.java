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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import mx.gob.imss.mssistrans.ccom.rutas.dto.DatosUsuarioDTO;
import mx.gob.imss.mssistrans.ccom.rutas.dto.ReAsignacionRutasDTO;
import mx.gob.imss.mssistrans.ccom.rutas.dto.RegistroRecorridoDTO;
import mx.gob.imss.mssistrans.ccom.rutas.dto.Response;
import mx.gob.imss.mssistrans.ccom.rutas.service.impl.ReasignacionRutasServiceImpl;
import mx.gob.imss.mssistrans.ccom.rutas.util.ValidaDatos;

import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author opimentel
 *
 */
@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
@RestController
@RequestMapping("/ReasignacionRutasCCOM")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ReasignacionRutasCCOMController {

	@Autowired
	ReasignacionRutasServiceImpl reasignacionRutasServiceImpl;

	@GetMapping
	public <T> ResponseEntity<Response> consultaGeneral(@RequestParam(defaultValue = "0") Integer pagina,
			@RequestParam(defaultValue = "10") Integer tamanio, @RequestParam(defaultValue = "") String ordenCol,
			@RequestParam(defaultValue = "ASC") String orden, @RequestParam(required = false) String idRutaAsig,
			@RequestParam(required = false) String idSolicitud) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = reasignacionRutasServiceImpl.consultaVistaRapida(pagina, tamanio, orden, ordenCol, idRutaAsig, 
			idSolicitud);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@DeleteMapping(path = "{idReAsignacion}")
	public <T> ResponseEntity<Response> delete(@PathVariable String idReAsignacion) {
		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = reasignacionRutasServiceImpl.delete(idReAsignacion);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	/****** HU006 - 28 **********/

	@GetMapping(path = "/getDetalleReAsignacion")
	public <T> ResponseEntity<Response> getDetalleReAsignacion(@RequestParam Integer idControlRuta) {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			DatosUsuarioDTO datosUsuarios = ValidaDatos.datosUsuarios();
			Response response = reasignacionRutasServiceImpl.getDetalleReAsignacion(idControlRuta);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	@GetMapping(path = "/ecco")
	public <T> ResponseEntity<Response> getEcco() {
		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			//DatosUsuarioDTO datosUsuario = ValidaDatos.datosUsuarios();
			Response response = reasignacionRutasServiceImpl.getEcco();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "/getTripulacionAsignada")
	public <T> ResponseEntity<Response> getTripulacionAsignada(@RequestParam(required = false) Integer idControlRuta
			, @RequestParam(required = false) Integer idRuta, @RequestParam(required = false) Integer idSolicitud
			, @RequestParam(required = false) Integer idVehiculo)  {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = reasignacionRutasServiceImpl.getTripulacionAsignada(idControlRuta, idRuta, idSolicitud, idVehiculo);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/getIncidentes")
	public <T> ResponseEntity<Response> getSiniestro() {

		Response<T> respuesta = new Response<>();
		if (ValidaDatos.getAccess()) {
			respuesta = ValidaDatos.noAutorizado(respuesta);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} else {
			Response response = reasignacionRutasServiceImpl.getSiniestro();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	
	@PostMapping(path = "/")
	public ResponseEntity<Response> save(@RequestParam Integer idVehiculo, @RequestParam Integer idRuta
			, @RequestParam Integer idChofer, @RequestParam String desMotivoReasig
			, @RequestParam String desSiniestro, @RequestParam(required = false) Integer idVehiculoSust
			, @RequestParam(required = false) Integer idChoferSust, @RequestParam Integer idAsignacion
			, @RequestParam String cveMatricula){
		
		Response response = reasignacionRutasServiceImpl.save(idVehiculo, idRuta, idChofer, desMotivoReasig
				, desSiniestro, idVehiculoSust, idChoferSust, idAsignacion
				, cveMatricula);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@PutMapping(path = "/")
	public ResponseEntity<Response> update(@RequestParam(required = false) String desSiniestro
			,@RequestParam(required = false) Integer idVehiculoSust
			, @RequestParam(required = false) String desMotivoReasignacion
			,@RequestParam Integer idVehiculo, @RequestParam Integer idRuta
			,@RequestParam Integer idChofer){
		
		Response response = reasignacionRutasServiceImpl.update(desSiniestro, idVehiculoSust, desMotivoReasignacion, idVehiculo, idRuta, idChofer);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
}
