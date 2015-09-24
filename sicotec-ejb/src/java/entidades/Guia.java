/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Guia.findByIdventa", query = "SELECT g FROM Guia g WHERE g.idventa = :idventa"),
    @NamedQuery(name = "Guia.findByIdcompra", query = "SELECT g FROM Guia g WHERE g.idcompra = :idcompra"),
    @NamedQuery(name = "Guia.findByFecha", query = "SELECT g FROM Guia g WHERE g.fecha = :fecha"),
    @NamedQuery(name = "Guia.findByIdalmacenOrigen", query = "SELECT g FROM Guia g WHERE g.idalmacenOrigen = :idalmacenOrigen"),
    @NamedQuery(name = "Guia.findByIdalmacenDestino", query = "SELECT g FROM Guia g WHERE g.idalmacenDestino = :idalmacenDestino"),
    @NamedQuery(name = "Guia.findByNombreOrigen", query = "SELECT g FROM Guia g WHERE g.nombreOrigen = :nombreOrigen"),
    @NamedQuery(name = "Guia.findByNombreDestino", query = "SELECT g FROM Guia g WHERE g.nombreDestino = :nombreDestino"),
    @NamedQuery(name = "Guia.findByMotivo", query = "SELECT g FROM Guia g WHERE g.motivo = :motivo"),
    @NamedQuery(name = "Guia.findByComentario", query = "SELECT g FROM Guia g WHERE g.comentario = :comentario"),
    @NamedQuery(name = "Guia.findByEstado", query = "SELECT g FROM Guia g WHERE g.estado = :estado"),
    @NamedQuery(name = "Guia.findByIddocumento", query = "SELECT g FROM Guia g WHERE g.iddocumento = :iddocumento")})
public class Guia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idguia")
    private Integer idguia;
    @Column(name = "idventa")
    private Integer idventa;
    @Column(name = "idcompra")
    private Integer idcompra;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "idalmacenOrigen")
    private Integer idalmacenOrigen;
    @Column(name = "idalmacenDestino")
    private Integer idalmacenDestino;
    @Size(max = 45)
    @Column(name = "nombreOrigen")
    private String nombreOrigen;
    @Size(max = 45)
    @Column(name = "nombreDestino")
    private String nombreDestino;
    @Size(max = 45)
    @Column(name = "motivo")
    private String motivo;
    @Size(max = 45)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 45)
    @Column(name = "iddocumento")
    private String iddocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guia")
    private List<Guiaitem> guiaitemList;
    @JoinColumn(name = "idtipoGuia", referencedColumnName = "idtipoGuia")
    @ManyToOne(optional = false)
    private Tipoguia idtipoGuia;

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

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdalmacenOrigen() {
        return idalmacenOrigen;
    }

    public void setIdalmacenOrigen(Integer idalmacenOrigen) {
        this.idalmacenOrigen = idalmacenOrigen;
    }

    public Integer getIdalmacenDestino() {
        return idalmacenDestino;
    }

    public void setIdalmacenDestino(Integer idalmacenDestino) {
        this.idalmacenDestino = idalmacenDestino;
    }

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    @XmlTransient
    public List<Guiaitem> getGuiaitemList() {
        return guiaitemList;
    }

    public void setGuiaitemList(List<Guiaitem> guiaitemList) {
        this.guiaitemList = guiaitemList;
    }

    public Tipoguia getIdtipoGuia() {
        return idtipoGuia;
    }

    public void setIdtipoGuia(Tipoguia idtipoGuia) {
        this.idtipoGuia = idtipoGuia;
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
