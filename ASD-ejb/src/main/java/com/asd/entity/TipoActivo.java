/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollo-MM
 */
@Entity
@Table(name = "tipoactivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActivo.findAll", query = "SELECT t FROM TipoActivo t")
    , @NamedQuery(name = "TipoActivo.findById", query = "SELECT t FROM TipoActivo t WHERE t.id = :id")
    , @NamedQuery(name = "TipoActivo.findByNombre", query = "SELECT t FROM TipoActivo t WHERE t.nombre = :nombre")})
public class TipoActivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipo", fetch = FetchType.LAZY)
    private List<ActivoFijo> activofijoList;

    public TipoActivo() {
    }

    public TipoActivo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<ActivoFijo> getActivofijoList() {
        return activofijoList;
    }

    public void setActivofijoList(List<ActivoFijo> activofijoList) {
        this.activofijoList = activofijoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActivo)) {
            return false;
        }
        TipoActivo other = (TipoActivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.TipoActivo[ id=" + id + " ]";
    }
    
}
