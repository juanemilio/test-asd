/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.service;

import com.asd.entity.EstadoActivoFijo;
import com.asd.lookup.EstadoActivoFijoDelegate;
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
@Path("estadoactivofijo")
public class EstadoActivoFijoFacadeREST {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public EstadoActivoFijoFacadeREST() {
    }

    /**
     * Busca los estados posibles que puede tomar un activo, por defecto:
     * 1;"Activo" 2;"Dado de baja" 3;"En reparación" 4;"Disponible" 5;"Asignado"
     *
     * @return estado 200 y lista de estados posibles que puede tomar un activo,
     * sino hay resultado retorna estado 404
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findAll() {
        List<EstadoActivoFijo> result = EstadoActivoFijoDelegate.listar();
        if (result != null && !result.isEmpty()) {
            GenericEntity<List<EstadoActivoFijo>> list = new GenericEntity<List<EstadoActivoFijo>>(result) {
            };
            return Response.status(Response.Status.OK).entity(list).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Sin resultados").build();
        }
    }

}
