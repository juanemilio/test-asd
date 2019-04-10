/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.service;

import com.asd.entity.ActivoFijo;
import com.asd.lookup.ActivoFijoDelegate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Stateless
@Path("activofijo")
public class ActivoFijoFacadeREST {

    @Context
    private UriInfo context;

    private final static Logger log = Logger.getLogger(ActivoFijoFacadeREST.class);

    /**
     * Crea un nueva instancia de ActivoFijoFacadeREST
     */
    public ActivoFijoFacadeREST() {
    }

    /**
     * Permite crear un nuevo registro de activo fijo
     *
     * @param entity Objeto de tipo Activo fijo
     * @return 200 si es exitoso, 400 si hay error en la validación de datos del
     * nuevo activo, 500 si hay un error interno
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response crear(ActivoFijo entity) {
        String resultadoValidacion = validarActivofijo(entity);
        if (!resultadoValidacion.equalsIgnoreCase("OK")) {
            //Error en la validación
            return Response.status(Response.Status.BAD_REQUEST).entity(resultadoValidacion).build();
        } else {
            try {
                ActivoFijoDelegate.crear(entity);
                return Response.status(Response.Status.OK).entity("Registro creado").build();
            } catch (Exception ex) {
                log.fatal(ex);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error interno").build();
            }
        }
    }

    /**
     * Permite editar un registro de activo fijo ya existente en la base de
     * datos
     *
     * @param entity Objeto de tipo Activo fijo a editar
     * @return 200 si es exitoso, 400 si hay error en la validación de datos del
     * activo, 500 si hay un error interno, 404 si no es encontrado el id del
     * activo en la base de datos
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response editar(ActivoFijo entity) {

        if (ActivoFijoDelegate.buscar(entity.getId()) == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Registro a editar no encontrado").build();
        }

        String resultadoValidacion = validarActivofijo(entity);
        if (!resultadoValidacion.equalsIgnoreCase("OK")) {
            //Error en la validación
            return Response.status(Response.Status.BAD_REQUEST).entity(resultadoValidacion).build();
        } else {
            try {
                ActivoFijoDelegate.editar(entity);
                return Response.status(Response.Status.OK).entity("Registro editado").build();
            } catch (Exception ex) {
                log.fatal(ex);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error interno").build();
            }
        }
    }

    /**
     * Lista todos los registros de activos fijo registrados en la base de datos
     *
     * @return Lista de activos y código 200 si es exitoso, 404 si no hay
     * resultados, 500 si hay un error interno
     */
    @GET
    @Path("/listartodo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listaTodo() {
        try {
            List<ActivoFijo> result = ActivoFijoDelegate.listar();
            if (result != null && !result.isEmpty()) {
                GenericEntity<List<ActivoFijo>> list = new GenericEntity<List<ActivoFijo>>(result) {
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

    /**
     * Busca en la base datos los activos que coincidan con los criterios de
     * búsqueda
     *
     * @param tipo Un id del tipo de activo a buscar, ingresar null para omitir
     * en la busqueda
     * @param fechaCompra Fecha de compra del activo, ingresal null para omitir
     * en la busqueda
     * @param serial Serial del activo, ingresar null para omitir en la busqueda
     * @return Un activo o un listado de activos que coincidan con los
     * parámetros de busqueda
     */
    @GET
    @Path("{tipo}/{fechacompra}/{serial}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("tipo") Integer tipo, @PathParam("fechacompra") String fechaCompra,
            @PathParam("serial") String serial) {
        try {
            Date fecha = null;
            if (!fechaCompra.equalsIgnoreCase("null") && fechaCompra.trim().isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    fecha = sdf.parse(fechaCompra);
                } catch (ParseException ex) {
                    log.fatal(ex);
                    fecha = null;
                }
            }

            List<ActivoFijo> result = ActivoFijoDelegate.filtar(tipo, fecha, serial);
            if (result != null && !result.isEmpty()) {
                GenericEntity<List<ActivoFijo>> list = new GenericEntity<List<ActivoFijo>>(result) {
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

    /**
     * Permite validar lo datos recibidos en un objeto tipo ActivoFijo y
     * validarlos, retornando un mensaje según sea el error de validación
     *
     * @param entity el objeto a validar sus datos
     * @return OK si la validación es exitosa, sino, retorna el mensaje
     * relacionado al error
     */
    private String validarActivofijo(ActivoFijo entity) {
        if (entity.getIdtipo() == null) {
            return "Especificar tipo de activo";
        }
        if (entity.getIdestado() == null) {
            return "Especificar el estado";
        }
        if (entity.getNumerointerno() == null) {
            return "Especificar el número interno";
        }
        if (entity.getSerial() == null) {
            return "Especificar el serial";
        }
        if (entity.getFechacompra() == null) {
            return "Definir la fecha de compra";
        }
        if (entity.getAlto() == null) {
            return "Ingrese un valor para el alto";
        }
        if (entity.getAncho() == null) {
            return "Ingrese un valor para el ancho";
        }
        if (entity.getLargo() == null) {
            return "Ingrese un valor para el largo";
        }
        if (entity.getPeso() == null) {
            return "Ingrese un valor para el peso";
        }
        if (entity.getColor() == null || entity.getColor().trim().isEmpty()) {
            return "Ingrese un color";
        }
        if (entity.getNombre() == null || entity.getNombre().trim().isEmpty()) {
            return "Ingrese un nombre";
        }
        if (entity.getDescripcion() == null || entity.getDescripcion().trim().isEmpty()) {
            return "Ingrese una descripción";
        }
        if (entity.getFechadebaja() != null && entity.getFechacompra().after(entity.getFechadebaja())) {
            return "La fecha debaja debe ser mayor a la de compra";
        }
        return "OK";
    }

}
