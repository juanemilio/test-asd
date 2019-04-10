/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.service;

import com.asd.entity.Ciudad;
import com.asd.lookup.CiudadDelegate;
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
@Path("ciudad")
public class CiudadFacadeREST {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public CiudadFacadeREST() {
    }

    /**
     * Busca todas las ciudades registradas en la base de datos
     *
     * @return Estado 200 y lista de objetos tipo ciudad registradas, sino hay
     * resultado retorna estado 404
     **/
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAll() {
        List<Ciudad> result = CiudadDelegate.listar();
        if (result != null && !result.isEmpty()) {
            GenericEntity<List<Ciudad>> list = new GenericEntity<List<Ciudad>>(result) {
            };
            return Response.status(Response.Status.OK).entity(list).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Sin resultados").build();
        }
    }

}
