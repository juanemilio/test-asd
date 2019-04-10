/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.lookup;


import com.asd.entity.TipoActivo;
import com.asd.facade.TipoActivoFacade;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Juan
 */
public class TipoActivoDelegate {

    private static TipoActivoFacade facade = lookup();

    private static TipoActivoFacade lookup() {
        try {
            Context c = new InitialContext();
            return (TipoActivoFacade) c.lookup("java:module/TipoActivoFacade");
        } catch (NamingException ne) {
            System.err.println(ne.toString());
            throw new RuntimeException(ne);
        }
    }

    public static void crear(TipoActivo f) {
        facade.create(f);
    }

    public static List<TipoActivo> listar() {
        return facade.findAll();
    }

    public static void eliminar(TipoActivo f) {
        facade.remove(f);
    }

    public static int contador() {
        return facade.count();
    }

    public static void editar(TipoActivo f) {
        facade.edit(f);
    }

    public static TipoActivo buscar(int id) {
        return facade.find(id);
    }

}
