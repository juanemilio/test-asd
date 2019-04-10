/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.facade;

import com.asd.entity.EstadoActivoFijo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Juan
 */
@Stateless
public class EstadoActivoFijoFacade extends AbstractFacade<EstadoActivoFijo> {

    @PersistenceContext(unitName = "ASD_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoActivoFijoFacade() {
        super(EstadoActivoFijo.class);
    }

 

}
