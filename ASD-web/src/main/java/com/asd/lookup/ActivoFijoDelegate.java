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
 * Permite hacer lookup al EJB ActivoFijoFacade y utilizar sus métodos
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

    /**
     * Permite persistir una entidad de la clase ActivoFijo
     *
     * @param f Entidad a persistir
     */
    public static void crear(ActivoFijo f) {
        facade.create(f);
    }

    /**
     * Retorna una lista con todos objetos del tipo ActivoFijo
     *
     * @return lista de objetos
     */
    public static List<ActivoFijo> listar() {
        return facade.findAll();
    }

    /**
     * Permite realizar un delete de un registro de la DB
     *
     * @param f Entity ActivoFijo a borrar
     */
    public static void eliminar(ActivoFijo f) {
        facade.remove(f);
    }

    /**
     * Cuenta el total de registro de ActivoFijo registrados en la DB
     *
     * @return Número entero con el total de registros en la DB
     */
    public static int contador() {
        return facade.count();
    }

    /**
     * Permite editar un registro de la DB
     *
     * @param f Entity tipo ActivoFijo a editar
     */
    public static void editar(ActivoFijo f) {
        facade.edit(f);
    }

    /**
     * Consultar un registro dado su Id o PrimaryKey
     *
     * @param id PrimaryKey del registro a buscar
     * @return Una Entity del tipo ActivoFijo si es encontrada, si no, null
     */
    public static ActivoFijo buscar(int id) {
        return facade.find(id);
    }

    /**
     * Listar ActivosFijo dado tres criterios de busqueda
     *
     * @param tipo Id del tipo de activo a buscar
     * @param fechaCompra Fecha de compra del activo
     * @param serial Serial del activo a buscar
     * @return Lista de los activos que coincidad con los criterios de busqueda
     */
    public static List<ActivoFijo> filtar(Integer tipo, Date fechaCompra, String serial) {
        return facade.filtrar(tipo, fechaCompra, serial);
    }

}
