/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.service;

import com.asd.entity.TipoActivo;
import com.asd.lookup.TipoActivoDelegate;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.apache.log4j.Logger;

/**
 *
 * @author Juan
 */
@Path("tipoactivo")
public class TipoActivoFacadeREST {

    @Context
    private UriInfo context;

    private final static Logger log = Logger.getLogger(TipoActivoFacadeREST.class);
    /**
     * Crea un nueva instancia de TipoActivoFacadeREST
     */
    public TipoActivoFacadeREST() {
    }

    /**
     * Busca los estados posibles que puede tomar un activo, por defecto:
     * 1;"Inmueble" 2;"Maquinaria" 3;"Meterial de oficina"
     *
     *
     * @return estado 200 y lista de estados posibles que puede tomar un activo,
     * sino hay resultado retorna estado 404
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findAll() {
        try {
            List<TipoActivo> result = TipoActivoDelegate.listar();
            if (result != null && !result.isEmpty()) {
                GenericEntity<List<TipoActivo>> list = new GenericEntity<List<TipoActivo>>(result) {
                };
                return Response.status(Response.Status.OK).entity(list).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Sin resultados").build();
            }
        } catch (Exception ex) {
            log.fatal(ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error interno").build();
        }
    }

}
