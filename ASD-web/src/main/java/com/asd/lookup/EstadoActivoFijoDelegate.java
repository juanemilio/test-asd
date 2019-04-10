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
 * Permite hacer lookup al EJB EstadoActivoFijoFacade y utilizar sus métodos
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

    /**
     * Permite persistir una entidad de la clase EstadoActivoFijo
     *
     * @param f Entidad a persistir
     */
    public static void crear(EstadoActivoFijo f) {
        facade.create(f);
    }

    /**
     * Retorna una lista con todos objetos del tipo EstadoActivoFijo
     *
     * @return lista de objetos
     */
    public static List<EstadoActivoFijo> listar() {
        return facade.findAll();
    }

    /**
     * Permite realizar un delete de un registro de la DB
     *
     * @param f Entity EstadoActivoFijo a borrar
     */
    public static void eliminar(EstadoActivoFijo f) {
        facade.remove(f);
    }

    /**
     * Cuenta el total de registro de EstadoActivoFijo registrados en la DB
     *
     * @return Número entero con el total de registros en la DB
     */
    public static int contador() {
        return facade.count();
    }

    /**
     * Permite editar un registro de la DB
     *
     * @param f Entity tipo EstadoActivoFijo a editar
     */
    public static void editar(EstadoActivoFijo f) {
        facade.edit(f);
    }

    public static EstadoActivoFijo buscar(int id) {
        return facade.find(id);
    }

}
