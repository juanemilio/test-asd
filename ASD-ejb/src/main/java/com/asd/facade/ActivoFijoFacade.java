/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.facade;

import com.asd.entity.ActivoFijo;
import com.asd.entity.TipoActivo;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Juan
 */
@Stateless
public class ActivoFijoFacade extends AbstractFacade<ActivoFijo> {

    @PersistenceContext(unitName = "ASD_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivoFijoFacade() {
        super(ActivoFijo.class);
    }

    public List<ActivoFijo> filtrar(Integer tipo, Date fechaCompra, String serial) {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<ActivoFijo> query = qb.createQuery(ActivoFijo.class);
        Root<ActivoFijo> activoFijo = query.from(ActivoFijo.class);

        List<Predicate> predicados = new LinkedList();

        if (tipo != null) {
            predicados.add(qb.equal(activoFijo.get("idtipo"), new TipoActivo(tipo)));
        }
        if (fechaCompra != null) {
            predicados.add(qb.equal(activoFijo.get("fechacompra"), fechaCompra));
        }
        if (serial != null) {
            predicados.add(qb.equal(activoFijo.get("serial"), serial));
        }

        Predicate[] predArray = new Predicate[predicados.size()];
        predicados.toArray(predArray);
        query.where(predArray);
        query.orderBy(qb.asc(activoFijo.get("nombre")));
        List<ActivoFijo> result = em.createQuery(query).getResultList();
        return result;
    }

}
