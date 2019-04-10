/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.lookup;

import com.asd.entity.EstadoActivoFijo;
import com.asd.facade.EstadoActivoFijoFacade;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Juan
 */
public class EstadoActivoFijoDelegate {

    private static EstadoActivoFijoFacade facade = lookup();

    private static EstadoActivoFijoFacade lookup() {
        try {
            Context c = new InitialContext();
            return (EstadoActivoFijoFacade) c.lookup("java:module/EstadoActivoFijoFacade");
        } catch (NamingException ne) {
            System.err.println(ne.toString());
            throw new RuntimeException(ne);
        }
    }

    public static void crear(EstadoActivoFijo f) {
        facade.create(f);
    }

    public static List<EstadoActivoFijo> listar() {
        return facade.findAll();
    }

    public static void eliminar(EstadoActivoFijo f) {
        facade.remove(f);
    }

    public static int contador() {
        return facade.count();
    }

    public static void editar(EstadoActivoFijo f) {
        facade.edit(f);
    }

    public static EstadoActivoFijo buscar(int id) {
        return facade.find(id);
    }

}
