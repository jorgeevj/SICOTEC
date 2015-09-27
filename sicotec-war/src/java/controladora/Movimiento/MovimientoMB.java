/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora.Movimiento;

import Util.Utils;
import bo.MovimientoBO;
import dto.TipomovimientoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class MovimientoMB {
    @EJB
    private MovimientoBO MovimientoBO = new MovimientoBO();
    Utils ut = new Utils();
    
    private List<TipomovimientoDTO> listaTipoMovimiento = new ArrayList<TipomovimientoDTO>();
    
    @PostConstruct
    public void init(){
        setListaTipoMovimiento(MovimientoBO.getAllTipoMovimiento());
        System.out.println(getListaTipoMovimiento().size());
    }
    
    public void selectRowTable(){
        System.out.println("APRETO!"); 
        //ut.mostrarNotificacion(RequestContext.getCurrentInstance(), "holi", 1000);
    }

    /**
     * @return the MovimientoBO
     */
    public MovimientoBO getMovimientoBO() {
        return MovimientoBO;
    }

    /**
     * @param MovimientoBO the MovimientoBO to set
     */
    public void setMovimientoBO(MovimientoBO MovimientoBO) {
        this.MovimientoBO = MovimientoBO;
    }

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
