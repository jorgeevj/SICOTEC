/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "guiaitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guiaitem.findAll", query = "SELECT g FROM Guiaitem g"),
    @NamedQuery(name = "Guiaitem.findByIdguia", query = "SELECT g FROM Guiaitem g WHERE g.guiaitemPK.idguia = :idguia"),
    @NamedQuery(name = "Guiaitem.findByIditem", query = "SELECT g FROM Guiaitem g WHERE g.guiaitemPK.iditem = :iditem"),
    @NamedQuery(name = "Guiaitem.findByEstado", query = "SELECT g FROM Guiaitem g WHERE g.estado = :estado")})
public class Guiaitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GuiaitemPK guiaitemPK;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "idguia", referencedColumnName = "idguia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Guia guia;
    @JoinColumn(name = "iditem", referencedColumnName = "iditem", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public Guiaitem() {
    }

    public Guiaitem(GuiaitemPK guiaitemPK) {
        this.guiaitemPK = guiaitemPK;
    }

    public Guiaitem(int idguia, int iditem) {
        this.guiaitemPK = new GuiaitemPK(idguia, iditem);
    }

    public GuiaitemPK getGuiaitemPK() {
        return guiaitemPK;
    }

    public void setGuiaitemPK(GuiaitemPK guiaitemPK) {
        this.guiaitemPK = guiaitemPK;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guiaitemPK != null ? guiaitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guiaitem)) {
            return false;
        }
        Guiaitem other = (Guiaitem) object;
        if ((this.guiaitemPK == null && other.guiaitemPK != null) || (this.guiaitemPK != null && !this.guiaitemPK.equals(other.guiaitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Guiaitem[ guiaitemPK=" + guiaitemPK + " ]";
    }
    
}
