/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Jorge
 */
@Entity
@Table(name = "tipoguia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoguia.findAll", query = "SELECT t FROM Tipoguia t"),
    @NamedQuery(name = "Tipoguia.findByIdtipoGuia", query = "SELECT t FROM Tipoguia t WHERE t.idtipoGuia = :idtipoGuia"),
    @NamedQuery(name = "Tipoguia.findByNombre", query = "SELECT t FROM Tipoguia t WHERE t.nombre = :nombre")})
public class Tipoguia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoGuia")
    private Integer idtipoGuia;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoGuia")
    private List<Guia> guiaList;

    public Tipoguia() {
    }

    public Tipoguia(Integer idtipoGuia) {
        this.idtipoGuia = idtipoGuia;
    }

    public Integer getIdtipoGuia() {
        return idtipoGuia;
    }

    public void setIdtipoGuia(Integer idtipoGuia) {
        this.idtipoGuia = idtipoGuia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoGuia != null ? idtipoGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoguia)) {
            return false;
        }
        Tipoguia other = (Tipoguia) object;
        if ((this.idtipoGuia == null && other.idtipoGuia != null) || (this.idtipoGuia != null && !this.idtipoGuia.equals(other.idtipoGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipoguia[ idtipoGuia=" + idtipoGuia + " ]";
    }
    
}
