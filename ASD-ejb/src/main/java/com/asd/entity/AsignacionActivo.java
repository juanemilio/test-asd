/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollo-MM
 */
@Entity
@Table(name = "asignacionactivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionActivo.findAll", query = "SELECT a FROM AsignacionActivo a")
    , @NamedQuery(name = "AsignacionActivo.findById", query = "SELECT a FROM AsignacionActivo a WHERE a.id = :id")
    , @NamedQuery(name = "AsignacionActivo.findByFecha", query = "SELECT a FROM AsignacionActivo a WHERE a.fecha = :fecha")})
public class AsignacionActivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinTable(name = "asignacionactijofijoxpersona", joinColumns = {
        @JoinColumn(name = "idasignacionactivofijo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idpersona", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Persona> personaList;
    @JoinColumn(name = "idactivofijo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ActivoFijo idactivofijo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "asignacionactivo", fetch = FetchType.LAZY)
    private Asignacionactijofijoxareaciudad asignacionactijofijoxareaciudad;

    public AsignacionActivo() {
    }

    public AsignacionActivo(Integer id) {
        this.id = id;
    }

    public AsignacionActivo(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public ActivoFijo getIdactivofijo() {
        return idactivofijo;
    }

    public void setIdactivofijo(ActivoFijo idactivofijo) {
        this.idactivofijo = idactivofijo;
    }

    public Asignacionactijofijoxareaciudad getAsignacionactijofijoxareaciudad() {
        return asignacionactijofijoxareaciudad;
    }

    public void setAsignacionactijofijoxareaciudad(Asignacionactijofijoxareaciudad asignacionactijofijoxareaciudad) {
        this.asignacionactijofijoxareaciudad = asignacionactijofijoxareaciudad;
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
        if (!(object instanceof AsignacionActivo)) {
            return false;
        }
        AsignacionActivo other = (AsignacionActivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.AsignacionActivo[ id=" + id + " ]";
    }
    
}
