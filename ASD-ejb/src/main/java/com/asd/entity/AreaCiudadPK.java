/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Desarrollo-MM
 */
@Embeddable
public class AreaCiudadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idarea")
    private int idarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idciudad")
    private int idciudad;

    public AreaCiudadPK() {
    }

    public AreaCiudadPK(int idarea, int idciudad) {
        this.idarea = idarea;
        this.idciudad = idciudad;
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idarea;
        hash += (int) idciudad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaCiudadPK)) {
            return false;
        }
        AreaCiudadPK other = (AreaCiudadPK) object;
        if (this.idarea != other.idarea) {
            return false;
        }
        if (this.idciudad != other.idciudad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.AreaciudadPK[ idarea=" + idarea + ", idciudad=" + idciudad + " ]";
    }
    
}
