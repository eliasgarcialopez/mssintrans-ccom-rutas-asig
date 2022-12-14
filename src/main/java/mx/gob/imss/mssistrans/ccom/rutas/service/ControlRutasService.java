package mx.gob.imss.mssistrans.ccom.rutas.service;

import mx.gob.imss.mssistrans.ccom.rutas.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ControlRutasService {
	 /**
     * Consulta todas las rutas
     *
     * @return
     */
    Respuesta<Page<ControlRutasTablaResponse>> consultarRutas(Pageable pageable);
    /**
     * Consulta los totales del vehiculos por modulo 
     *
     * @param idControlRuta
     * @return
     */
    Respuesta<ControlRutasTotalesResponse> consultarTotalesVehiculos();
    
    /**
     * Consulta una ruta y su control por el Identificador
     *
     * @param idControlRuta
     * @return
     */
    Respuesta<ControlRutasResponse> consultarRutas(Integer idControlRuta);

    /**
     * Crea un nueva Ruta
     */
    Respuesta<Integer> crearRuta(ControlRutasRequest rutas);

    /**
     * Edita una ruta de acuerdo al Identificador
     *
     * @param idRuta
     * @param RutasDTO
     */
    Respuesta<Integer> editarRuta(Integer idControlRuta, ControlRutasRequest rutaDTO);

    /**
     * Elimina una asingacion Ruta, la eliminaci&oacute;n es l&oacute;gica;
     *
     * @param idControlRuta
     */
    Respuesta<Integer> eliminarRutas(Integer idControlRuta);


    /**
     * Libera los recursos que se asignaron al control de rutas
     *
     * @param idRuta
     * @param params
     * @return
     */
    Respuesta<?> liberarControlRuta(Integer idRuta, LiberarControlRutasRequest params);
}
