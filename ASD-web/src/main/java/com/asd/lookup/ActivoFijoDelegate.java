/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.lookup;

import com.asd.entity.ActivoFijo;
import com.asd.facade.ActivoFijoFacade;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Juan
 */
public class ActivoFijoDelegate {

    private static ActivoFijoFacade facade = lookup();

    private static ActivoFijoFacade lookup() {
        try {
            Context c = new InitialContext();
            return (ActivoFijoFacade) c.lookup("java:module/ActivoFijoFacade");
        } catch (NamingException ne) {
            System.err.println(ne.toString());
            throw new RuntimeException(ne);
        }
    }

    public static void crear(ActivoFijo f) {
        facade.create(f);
    }

    public static List<ActivoFijo> listar() {
        return facade.findAll();
    }

    public static void eliminar(ActivoFijo f) {
        facade.remove(f);
    }

    public static int contador() {
        return facade.count();
    }

    public static void editar(ActivoFijo f) {
        facade.edit(f);
    }

    public static ActivoFijo buscar(int id) {
        return facade.find(id);
    }
    
     public static List<ActivoFijo> filtar(Integer tipo, Date fechaCompra, String serial) {
        return facade.filtrar(tipo, fechaCompra, serial);
    }

}
