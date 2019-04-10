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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollo-MM
 */
@Entity
@Table(name = "estadoactivofijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoActivoFijo.findAll", query = "SELECT e FROM EstadoActivoFijo e")
    , @NamedQuery(name = "EstadoActivoFijo.findById", query = "SELECT e FROM EstadoActivoFijo e WHERE e.id = :id")
    , @NamedQuery(name = "EstadoActivoFijo.findByNombre", query = "SELECT e FROM EstadoActivoFijo e WHERE e.nombre = :nombre")})
public class EstadoActivoFijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado", fetch = FetchType.LAZY)
    private List<ActivoFijo> activofijoList;

    public EstadoActivoFijo() {
    }

    public EstadoActivoFijo(Integer id) {
        this.id = id;
    }

    public EstadoActivoFijo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
        if (!(object instanceof EstadoActivoFijo)) {
            return false;
        }
        EstadoActivoFijo other = (EstadoActivoFijo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.EstadoActivoFijo[ id=" + id + " ]";
    }
    
}
