/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.lookup;

import com.asd.entity.Ciudad;
import com.asd.facade.CiudadFacade;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Permite hacer lookup al EJB CiudadFacade y utilizar sus métodos
 *
 * @author Juan
 */
public class CiudadDelegate {

    private static CiudadFacade facade = lookup();

    private static CiudadFacade lookup() {
        try {
            Context c = new InitialContext();
            return (CiudadFacade) c.lookup("java:module/CiudadFacade");
        } catch (NamingException ne) {
            System.err.println(ne.toString());
            throw new RuntimeException(ne);
        }
    }

    /**
     * Permite persistir una entidad de la clase Ciudad
     *
     * @param f Entidad a persistir
     */
    public static void crear(Ciudad f) {
        facade.create(f);
    }

    /**
     * Retorna una lista con todos objetos del tipo Ciudad
     *
     * @return lista de objetos
     */
    public static List<Ciudad> listar() {
        return facade.findAll();
    }

    /**
     * Permite realizar un delete de un registro de la DB
     *
     * @param f Entity Ciudad a borrar
     */
    public static void eliminar(Ciudad f) {
        facade.remove(f);
    }

    /**
     * Cuenta el total de registro de Ciudad registrados en la DB
     *
     * @return Número entero con el total de registros en la DB
     */
    public static int contador() {
        return facade.count();
    }

    /**
     * Permite editar un registro de la DB
     *
     * @param f Entity tipo Ciudad a editar
     */
    public static void editar(Ciudad f) {
        facade.edit(f);
    }

    /**
     * Consultar un registro dado su Id o PrimaryKey
     *
     * @param id PrimaryKey del registro a buscar
     * @return Una Entity del tipo Ciudad si es encontrada, si no, null
     */
    public static Ciudad buscar(int id) {
        return facade.find(id);
    }

}
