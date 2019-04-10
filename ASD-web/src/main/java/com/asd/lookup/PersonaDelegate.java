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

    public static void crear(Persona f) {
        facade.create(f);
    }

    public static List<Persona> listar() {
        return facade.findAll();
    }

    public static void eliminar(Persona f) {
        facade.remove(f);
    }

    public static int contador() {
        return facade.count();
    }

    public static void editar(Persona f) {
        facade.edit(f);
    }

    public static Persona buscar(int id) {
        return facade.find(id);
    }

}
