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
    
    private SessionBeanMovimiento sessionBeanMovimiento = new SessionBeanMovimiento();
    Utils ut = new Utils();
    
    
    
    @PostConstruct
    public void init(){
        getSessionBeanMovimiento().setListaTipoMovimiento(MovimientoBO.getAllTipoMovimiento());
    }
    
    public void selectRowTable(){
        
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
     * @return the sessionBeanMovimiento
     */
    public SessionBeanMovimiento getSessionBeanMovimiento() {
        return sessionBeanMovimiento;
    }

    /**
     * @param sessionBeanMovimiento the sessionBeanMovimiento to set
     */
    public void setSessionBeanMovimiento(SessionBeanMovimiento sessionBeanMovimiento) {
        this.sessionBeanMovimiento = sessionBeanMovimiento;
    }


}
