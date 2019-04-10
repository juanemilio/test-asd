/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desarrollo-MM
 */
@Entity
@Table(name = "asignacionactijofijoxareaciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacionactijofijoxareaciudad.findAll", query = "SELECT a FROM Asignacionactijofijoxareaciudad a")
    , @NamedQuery(name = "Asignacionactijofijoxareaciudad.findByIdasignacionactivofijo", query = "SELECT a FROM Asignacionactijofijoxareaciudad a WHERE a.idasignacionactivofijo = :idasignacionactivofijo")})
public class Asignacionactijofijoxareaciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasignacionactivofijo")
    private Integer idasignacionactivofijo;
    @JoinColumns({
        @JoinColumn(name = "idarea", referencedColumnName = "idarea")
        , @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AreaCiudad areaciudad;
    @JoinColumn(name = "idasignacionactivofijo", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private AsignacionActivo asignacionactivo;

    public Asignacionactijofijoxareaciudad() {
    }

    public Asignacionactijofijoxareaciudad(Integer idasignacionactivofijo) {
        this.idasignacionactivofijo = idasignacionactivofijo;
    }

    public Integer getIdasignacionactivofijo() {
        return idasignacionactivofijo;
    }

    public void setIdasignacionactivofijo(Integer idasignacionactivofijo) {
        this.idasignacionactivofijo = idasignacionactivofijo;
    }

    public AreaCiudad getAreaciudad() {
        return areaciudad;
    }

    public void setAreaciudad(AreaCiudad areaciudad) {
        this.areaciudad = areaciudad;
    }

    public AsignacionActivo getAsignacionactivo() {
        return asignacionactivo;
    }

    public void setAsignacionactivo(AsignacionActivo asignacionactivo) {
        this.asignacionactivo = asignacionactivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignacionactivofijo != null ? idasignacionactivofijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacionactijofijoxareaciudad)) {
            return false;
        }
        Asignacionactijofijoxareaciudad other = (Asignacionactijofijoxareaciudad) object;
        if ((this.idasignacionactivofijo == null && other.idasignacionactivofijo != null) || (this.idasignacionactivofijo != null && !this.idasignacionactivofijo.equals(other.idasignacionactivofijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.Asignacionactijofijoxareaciudad[ idasignacionactivofijo=" + idasignacionactivofijo + " ]";
    }
    
}
