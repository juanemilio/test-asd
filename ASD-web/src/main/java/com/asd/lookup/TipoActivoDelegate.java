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
 * Permite hacer lookup al EJB TipoActivoFacade y utilizar sus métodos
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

    /**
     * Permite persistir una entidad de la clase TipoActivo
     *
     * @param f Entidad a persistir
     */
    public static void crear(TipoActivo f) {
        facade.create(f);
    }

    /**
     * Retorna una lista con todos objetos del tipo TipoActivo
     *
     * @return lista de objetos
     */
    public static List<TipoActivo> listar() {
        return facade.findAll();
    }

    /**
     * Permite realizar un delete de un registro de la DB
     *
     * @param f Entity TipoActivo a borrar
     */
    public static void eliminar(TipoActivo f) {
        facade.remove(f);
    }

    /**
     * Cuenta el total de registro de TipoActivo registrados en la DB
     *
     * @return Número entero con el total de registros en la DB
     */
    public static int contador() {
        return facade.count();
    }

    /**
     * Permite editar un registro de la DB
     *
     * @param f Entity tipo TipoActivo a editar
     */
    public static void editar(TipoActivo f) {
        facade.edit(f);
    }

    /**
     * Consultar un registro dado su Id o PrimaryKey
     *
     * @param id PrimaryKey del registro a buscar
     * @return Una Entity del tipo TipoActivo si es encontrada, si no, null
     */
    public static TipoActivo buscar(int id) {
        return facade.find(id);
    }

}
