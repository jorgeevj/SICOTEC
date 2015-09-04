/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author Jorge
 */
@Entity
@Table(name = "tipoitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoitem.findAll", query = "SELECT t FROM Tipoitem t"),
    @NamedQuery(name = "Tipoitem.findByIdtipoItem", query = "SELECT t FROM Tipoitem t WHERE t.idtipoItem = :idtipoItem"),
    @NamedQuery(name = "Tipoitem.findByNombre", query = "SELECT t FROM Tipoitem t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tipoitem.findByTipo", query = "SELECT t FROM Tipoitem t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tipoitem.findByPrecioLista", query = "SELECT t FROM Tipoitem t WHERE t.precioLista = :precioLista")})
public class Tipoitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoItem")
    private Integer idtipoItem;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioLista")
    private Double precioLista;
    @ManyToMany(mappedBy = "tipoitemCollection")
    private Collection<Familia> familiaCollection;
    @ManyToMany(mappedBy = "tipoitemCollection")
    private Collection<Marca> marcaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoitem")
    private Collection<Cotipoitem> cotipoitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoitem")
    private Collection<Catipoitem> catipoitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoitem")
    private Collection<Altipoitem> altipoitemCollection;

    public Tipoitem() {
    }

    public Tipoitem(Integer idtipoItem) {
        this.idtipoItem = idtipoItem;
    }

    public Integer getIdtipoItem() {
        return idtipoItem;
    }

    public void setIdtipoItem(Integer idtipoItem) {
        this.idtipoItem = idtipoItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(Double precioLista) {
        this.precioLista = precioLista;
    }

    @XmlTransient
    public Collection<Familia> getFamiliaCollection() {
        return familiaCollection;
    }

    public void setFamiliaCollection(Collection<Familia> familiaCollection) {
        this.familiaCollection = familiaCollection;
    }

    @XmlTransient
    public Collection<Marca> getMarcaCollection() {
        return marcaCollection;
    }

    public void setMarcaCollection(Collection<Marca> marcaCollection) {
        this.marcaCollection = marcaCollection;
    }

    @XmlTransient
    public Collection<Cotipoitem> getCotipoitemCollection() {
        return cotipoitemCollection;
    }

    public void setCotipoitemCollection(Collection<Cotipoitem> cotipoitemCollection) {
        this.cotipoitemCollection = cotipoitemCollection;
    }

    @XmlTransient
    public Collection<Catipoitem> getCatipoitemCollection() {
        return catipoitemCollection;
    }

    public void setCatipoitemCollection(Collection<Catipoitem> catipoitemCollection) {
        this.catipoitemCollection = catipoitemCollection;
    }

    @XmlTransient
    public Collection<Altipoitem> getAltipoitemCollection() {
        return altipoitemCollection;
    }

    public void setAltipoitemCollection(Collection<Altipoitem> altipoitemCollection) {
        this.altipoitemCollection = altipoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoItem != null ? idtipoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoitem)) {
            return false;
        }
        Tipoitem other = (Tipoitem) object;
        if ((this.idtipoItem == null && other.idtipoItem != null) || (this.idtipoItem != null && !this.idtipoItem.equals(other.idtipoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipoitem[ idtipoItem=" + idtipoItem + " ]";
    }
    
}
