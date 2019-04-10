/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollo-MM
 */
@Entity
@Table(name = "areaciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaCiudad.findAll", query = "SELECT a FROM AreaCiudad a")
    , @NamedQuery(name = "AreaCiudad.findByIdarea", query = "SELECT a FROM AreaCiudad a WHERE a.areaciudadPK.idarea = :idarea")
    , @NamedQuery(name = "AreaCiudad.findByIdciudad", query = "SELECT a FROM AreaCiudad a WHERE a.areaciudadPK.idciudad = :idciudad")})
public class AreaCiudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreaCiudadPK areaciudadPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaciudad", fetch = FetchType.LAZY)
    private List<Asignacionactijofijoxareaciudad> asignacionactijofijoxareaciudadList;
    @JoinColumn(name = "idarea", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Area area;
    @JoinColumn(name = "idciudad", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudad ciudad;

    public AreaCiudad() {
    }

    public AreaCiudad(AreaCiudadPK areaciudadPK) {
        this.areaciudadPK = areaciudadPK;
    }

    public AreaCiudad(int idarea, int idciudad) {
        this.areaciudadPK = new AreaCiudadPK(idarea, idciudad);
    }

    public AreaCiudadPK getAreaCiudadPK() {
        return areaciudadPK;
    }

    public void setAreaCiudadPK(AreaCiudadPK areaciudadPK) {
        this.areaciudadPK = areaciudadPK;
    }

    @XmlTransient
    public List<Asignacionactijofijoxareaciudad> getAsignacionactijofijoxareaciudadList() {
        return asignacionactijofijoxareaciudadList;
    }

    public void setAsignacionactijofijoxareaciudadList(List<Asignacionactijofijoxareaciudad> asignacionactijofijoxareaciudadList) {
        this.asignacionactijofijoxareaciudadList = asignacionactijofijoxareaciudadList;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaciudadPK != null ? areaciudadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaCiudad)) {
            return false;
        }
        AreaCiudad other = (AreaCiudad) object;
        if ((this.areaciudadPK == null && other.areaciudadPK != null) || (this.areaciudadPK != null && !this.areaciudadPK.equals(other.areaciudadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.AreaCiudad[ areaciudadPK=" + areaciudadPK + " ]";
    }
    
}
