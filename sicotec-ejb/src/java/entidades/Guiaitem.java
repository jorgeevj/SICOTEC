/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Guiaitem.findByMotivo", query = "SELECT g FROM Guiaitem g WHERE g.motivo = :motivo"),
    @NamedQuery(name = "Guiaitem.findByComentario", query = "SELECT g FROM Guiaitem g WHERE g.comentario = :comentario"),
    @NamedQuery(name = "Guiaitem.findByOrigen", query = "SELECT g FROM Guiaitem g WHERE g.origen = :origen"),
    @NamedQuery(name = "Guiaitem.findByDestino", query = "SELECT g FROM Guiaitem g WHERE g.destino = :destino"),
    @NamedQuery(name = "Guiaitem.findByFecha", query = "SELECT g FROM Guiaitem g WHERE g.fecha = :fecha"),
    @NamedQuery(name = "Guiaitem.findByIditem", query = "SELECT g FROM Guiaitem g WHERE g.guiaitemPK.iditem = :iditem"),
    @NamedQuery(name = "Guiaitem.findByIdguia", query = "SELECT g FROM Guiaitem g WHERE g.guiaitemPK.idguia = :idguia"),
    @NamedQuery(name = "Guiaitem.findByEstado", query = "SELECT g FROM Guiaitem g WHERE g.estado = :estado")})
public class Guiaitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GuiaitemPK guiaitemPK;
    @Size(max = 45)
    @Column(name = "motivo")
    private String motivo;
    @Size(max = 45)
    @Column(name = "comentario")
    private String comentario;
    @Size(max = 45)
    @Column(name = "origen")
    private String origen;
    @Size(max = 45)
    @Column(name = "destino")
    private String destino;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "idalmacenOrigen", referencedColumnName = "idalmacen")
    @ManyToOne
    private Almacen idalmacenOrigen;
    @JoinColumn(name = "idalmacenDestino", referencedColumnName = "idalmacen")
    @ManyToOne
    private Almacen idalmacenDestino;
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

    public Guiaitem(int iditem, int idguia) {
        this.guiaitemPK = new GuiaitemPK(iditem, idguia);
    }

    public GuiaitemPK getGuiaitemPK() {
        return guiaitemPK;
    }

    public void setGuiaitemPK(GuiaitemPK guiaitemPK) {
        this.guiaitemPK = guiaitemPK;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Almacen getIdalmacenOrigen() {
        return idalmacenOrigen;
    }

    public void setIdalmacenOrigen(Almacen idalmacenOrigen) {
        this.idalmacenOrigen = idalmacenOrigen;
    }

    public Almacen getIdalmacenDestino() {
        return idalmacenDestino;
    }

    public void setIdalmacenDestino(Almacen idalmacenDestino) {
        this.idalmacenDestino = idalmacenDestino;
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
