/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.service;

import com.asd.entity.Area;
import com.asd.lookup.AreaDelegate;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Juan
 */
@Path("area")
public class AreaFacadeREST {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public AreaFacadeREST() {
    }

    /**
     * Busca todas las áreas registradas en la base de datos
     *
     * @return estado 200 y lista de las áreas registradas, si no hay resultado
     * retorna estado 404
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listarTodo() {
        List<Area> result = AreaDelegate.listar();
        if (result != null && !result.isEmpty()) {
            GenericEntity<List<Area>> list = new GenericEntity<List<Area>>(result) {
            };
            return Response.status(Response.Status.OK).entity(list).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Sin resultados").build();
        }
    }

}
