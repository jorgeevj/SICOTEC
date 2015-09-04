/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorge
 */
@Embeddable
public class GuiaitemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "iditem")
    private int iditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idguia")
    private int idguia;

    public GuiaitemPK() {
    }

    public GuiaitemPK(int iditem, int idguia) {
        this.iditem = iditem;
        this.idguia = idguia;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public int getIdguia() {
        return idguia;
    }

    public void setIdguia(int idguia) {
        this.idguia = idguia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iditem;
        hash += (int) idguia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaitemPK)) {
            return false;
        }
        GuiaitemPK other = (GuiaitemPK) object;
        if (this.iditem != other.iditem) {
            return false;
        }
        if (this.idguia != other.idguia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.GuiaitemPK[ iditem=" + iditem + ", idguia=" + idguia + " ]";
    }
    
}
