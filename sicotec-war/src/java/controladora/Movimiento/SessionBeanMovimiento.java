/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora.Movimiento;

import dto.TipomovimientoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rikardo308
 */

@ManagedBean
@SessionScoped
public class SessionBeanMovimiento {
    private List<TipomovimientoDTO> listaTipoMovimiento = new ArrayList<TipomovimientoDTO>();

    /**
     * @return the listaTipoMovimiento
     */
    public List<TipomovimientoDTO> getListaTipoMovimiento() {
        return listaTipoMovimiento;
    }

    /**
     * @param listaTipoMovimiento the listaTipoMovimiento to set
     */
    public void setListaTipoMovimiento(List<TipomovimientoDTO> listaTipoMovimiento) {
        this.listaTipoMovimiento = listaTipoMovimiento;
    }
    
}
