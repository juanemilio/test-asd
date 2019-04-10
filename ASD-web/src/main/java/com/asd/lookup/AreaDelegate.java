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
 * Permite hacer lookup al EJB AreaFacade y utilizar sus métodos
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

    /**
     * Permite persistir una entidad de la clase Area
     *
     * @param f Entidad a persistir
     */
    public static void crear(Area f) {
        facade.create(f);
    }

    /**
     * Retorna una lista con todos objetos del tipo Area
     *
     * @return lista de objetos
     */
    public static List<Area> listar() {
        return facade.findAll();
    }

    /**
     * Permite realizar un delete de un registro de la DB
     *
     * @param f Entity Area a borrar
     */
    public static void eliminar(Area f) {
        facade.remove(f);
    }

    /**
     * Cuenta el total de registro de Area registrados en la DB
     *
     * @return Número entero con el total de registros en la DB
     */
    public static int contador() {
        return facade.count();
    }

    /**
     * Permite editar un registro de la DB
     *
     * @param f Entity tipo Area a editar
     */
    public static void editar(Area f) {
        facade.edit(f);
    }

    /**
     * Consultar un registro dado su Id o PrimaryKey
     *
     * @param id PrimaryKey del registro a buscar
     * @return Una Entity del tipo Area si es encontrada, si no, null
     */
    public static Area buscar(int id) {
        return facade.find(id);
    }

}
