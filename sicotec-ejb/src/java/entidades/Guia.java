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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "guia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g"),
    @NamedQuery(name = "Guia.findByIdguia", query = "SELECT g FROM Guia g WHERE g.idguia = :idguia"),
    @NamedQuery(name = "Guia.findByTipo", query = "SELECT g FROM Guia g WHERE g.tipo = :tipo"),
    @NamedQuery(name = "Guia.findByEstado", query = "SELECT g FROM Guia g WHERE g.estado = :estado")})
public class Guia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idguia")
    private Integer idguia;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guia")
    private Collection<Guiaitem> guiaitemCollection;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    @ManyToOne
    private Venta idventa;

    public Guia() {
    }

    public Guia(Integer idguia) {
        this.idguia = idguia;
    }

    public Integer getIdguia() {
        return idguia;
    }

    public void setIdguia(Integer idguia) {
        this.idguia = idguia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Guiaitem> getGuiaitemCollection() {
        return guiaitemCollection;
    }

    public void setGuiaitemCollection(Collection<Guiaitem> guiaitemCollection) {
        this.guiaitemCollection = guiaitemCollection;
    }

    public Venta getIdventa() {
        return idventa;
    }

    public void setIdventa(Venta idventa) {
        this.idventa = idventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idguia != null ? idguia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.idguia == null && other.idguia != null) || (this.idguia != null && !this.idguia.equals(other.idguia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Guia[ idguia=" + idguia + " ]";
    }
    
}
