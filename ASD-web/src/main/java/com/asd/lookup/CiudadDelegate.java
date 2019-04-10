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

    public static void crear(Ciudad f) {
        facade.create(f);
    }

    public static List<Ciudad> listar() {
        return facade.findAll();
    }

    public static void eliminar(Ciudad f) {
        facade.remove(f);
    }

    public static int contador() {
        return facade.count();
    }

    public static void editar(Ciudad f) {
        facade.edit(f);
    }

    public static Ciudad buscar(int id) {
        return facade.find(id);
    }

}
