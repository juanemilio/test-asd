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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollo-MM
 */
@Entity
@Table(name = "activofijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoFijo.findAll", query = "SELECT a FROM ActivoFijo a")
    , @NamedQuery(name = "ActivoFijo.findById", query = "SELECT a FROM ActivoFijo a WHERE a.id = :id")
    , @NamedQuery(name = "ActivoFijo.findByNombre", query = "SELECT a FROM ActivoFijo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "ActivoFijo.findByDescripcion", query = "SELECT a FROM ActivoFijo a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "ActivoFijo.findBySerial", query = "SELECT a FROM ActivoFijo a WHERE a.serial = :serial")
    , @NamedQuery(name = "ActivoFijo.findByNumerointerno", query = "SELECT a FROM ActivoFijo a WHERE a.numerointerno = :numerointerno")
    , @NamedQuery(name = "ActivoFijo.findByPeso", query = "SELECT a FROM ActivoFijo a WHERE a.peso = :peso")
    , @NamedQuery(name = "ActivoFijo.findByAlto", query = "SELECT a FROM ActivoFijo a WHERE a.alto = :alto")
    , @NamedQuery(name = "ActivoFijo.findByAncho", query = "SELECT a FROM ActivoFijo a WHERE a.ancho = :ancho")
    , @NamedQuery(name = "ActivoFijo.findByLargo", query = "SELECT a FROM ActivoFijo a WHERE a.largo = :largo")
    , @NamedQuery(name = "ActivoFijo.findByValorcompra", query = "SELECT a FROM ActivoFijo a WHERE a.valorcompra = :valorcompra")
    , @NamedQuery(name = "ActivoFijo.findByFechacompra", query = "SELECT a FROM ActivoFijo a WHERE a.fechacompra = :fechacompra")
    , @NamedQuery(name = "ActivoFijo.findByFechadebaja", query = "SELECT a FROM ActivoFijo a WHERE a.fechadebaja = :fechadebaja")
    , @NamedQuery(name = "ActivoFijo.findByColor", query = "SELECT a FROM ActivoFijo a WHERE a.color = :color")})
public class ActivoFijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numerointerno")
    private String numerointerno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "alto")
    private Double alto;
    @Column(name = "ancho")
    private Double ancho;
    @Column(name = "largo")
    private Double largo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorcompra")
    private double valorcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacompra")
    @Temporal(TemporalType.DATE)
    private Date fechacompra;
    @Column(name = "fechadebaja")
    @Temporal(TemporalType.DATE)
    private Date fechadebaja;
    @Size(max = 100)
    @Column(name = "color")
    private String color;
    @JoinColumn(name = "idestado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoActivoFijo idestado;
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoActivo idtipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactivofijo", fetch = FetchType.LAZY)
    private List<AsignacionActivo> asignacionactivoList;

    public ActivoFijo() {
    }

    public ActivoFijo(Integer id) {
        this.id = id;
    }

    public ActivoFijo(Integer id, String nombre, String serial, String numerointerno, double valorcompra, Date fechacompra) {
        this.id = id;
        this.nombre = nombre;
        this.serial = serial;
        this.numerointerno = numerointerno;
        this.valorcompra = valorcompra;
        this.fechacompra = fechacompra;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumerointerno() {
        return numerointerno;
    }

    public void setNumerointerno(String numerointerno) {
        this.numerointerno = numerointerno;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public Date getFechadebaja() {
        return fechadebaja;
    }

    public void setFechadebaja(Date fechadebaja) {
        this.fechadebaja = fechadebaja;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public EstadoActivoFijo getIdestado() {
        return idestado;
    }

    public void setIdestado(EstadoActivoFijo idestado) {
        this.idestado = idestado;
    }

    public TipoActivo getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(TipoActivo idtipo) {
        this.idtipo = idtipo;
    }

    @XmlTransient
    public List<AsignacionActivo> getAsignacionactivoList() {
        return asignacionactivoList;
    }

    public void setAsignacionactivoList(List<AsignacionActivo> asignacionactivoList) {
        this.asignacionactivoList = asignacionactivoList;
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
        if (!(object instanceof ActivoFijo)) {
            return false;
        }
        ActivoFijo other = (ActivoFijo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.ActivoFijo[ id=" + id + " ]";
    }
    
}
