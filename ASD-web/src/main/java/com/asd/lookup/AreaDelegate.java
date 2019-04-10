/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.lookup;

import com.asd.entity.Area;
import com.asd.facade.AreaFacade;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Juan
 */
public class AreaDelegate {

    private static AreaFacade facade = lookup();

    private static AreaFacade lookup() {
        try {
            Context c = new InitialContext();
            return (AreaFacade) c.lookup("java:module/AreaFacade");
        } catch (NamingException ne) {
            System.err.println(ne.toString());
            throw new RuntimeException(ne);
        }
    }

    public static void crear(Area f) {
        facade.create(f);
    }

    public static List<Area> listar() {
        return facade.findAll();
    }

    public static void eliminar(Area f) {
        facade.remove(f);
    }

    public static int contador() {
        return facade.count();
    }

    public static void editar(Area f) {
        facade.edit(f);
    }

    public static Area buscar(int id) {
        return facade.find(id);
    }

}
