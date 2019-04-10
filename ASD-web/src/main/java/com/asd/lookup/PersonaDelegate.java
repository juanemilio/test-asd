/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.lookup;

import com.asd.entity.Persona;
import com.asd.facade.PersonaFacade;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Permite hacer lookup al EJB PersonaFacade y utilizar sus métodos
 *
 * @author Juan
 */
public class PersonaDelegate {

    private static PersonaFacade facade = lookup();

    private static PersonaFacade lookup() {
        try {
            Context c = new InitialContext();
            return (PersonaFacade) c.lookup("java:module/PersonaFacade");
        } catch (NamingException ne) {
            System.err.println(ne.toString());
            throw new RuntimeException(ne);
        }
    }

    /**
     * Permite persistir una entidad de la clase Persona
     *
     * @param f Entidad a persistir
     */
    public static void crear(Persona f) {
        facade.create(f);
    }

    /**
     * Retorna una lista con todos objetos del tipo Persona
     *
     * @return lista de objetos
     */
    public static List<Persona> listar() {
        return facade.findAll();
    }

    /**
     * Permite realizar un delete de un registro de la DB
     *
     * @param f Entity Persona a borrar
     */
    public static void eliminar(Persona f) {
        facade.remove(f);
    }

    /**
     * Cuenta el total de registro de Persona registrados en la DB
     *
     * @return Número entero con el total de registros en la DB
     */
    public static int contador() {
        return facade.count();
    }

    /**
     * Permite editar un registro de la DB
     *
     * @param f Entity tipo Persona a editar
     */
    public static void editar(Persona f) {
        facade.edit(f);
    }

    /**
     * Consultar un registro dado su Id o PrimaryKey
     *
     * @param id PrimaryKey del registro a buscar
     * @return Una Entity del tipo Persona si es encontrada, si no, null
     */
    public static Persona buscar(int id) {
        return facade.find(id);
    }

}
