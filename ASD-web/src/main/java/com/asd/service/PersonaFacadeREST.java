/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.service;

import com.asd.entity.Persona;
import com.asd.lookup.PersonaDelegate;
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
@Path("persona")
public class PersonaFacadeREST {

    @Context
    private UriInfo context;
    
    
    private final static Logger log = Logger.getLogger(PersonaFacadeREST.class);

    /**
     * Crea un nueva instancia de PersonaFacadeREST
     */
    public PersonaFacadeREST() {
    }

    /**
     * Busca todas los datos de las personas registradas en la base de datos
     *
     * @return Estado 200 y lista de objetos tipo persona registradas, sino hay
     * resultado retorna estado 404
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listarTodo() {
        try {
            List<Persona> result = PersonaDelegate.listar();
            if (result != null && !result.isEmpty()) {
                GenericEntity<List<Persona>> list = new GenericEntity<List<Persona>>(result) {
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
