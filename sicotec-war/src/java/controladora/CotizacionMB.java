/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora;

import bo.CotizacionBO;
import entidades.Cotizacion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jorge
 */
@ManagedBean
@SessionScoped
public class CotizacionMB {
    
@EJB
private CotizacionBO cotizacionBO;

private List<Cotizacion> listaCotizacion;
    /**
     * Creates a new instance of CotizacionMB
     */
    public CotizacionMB() {
    }
   @PostConstruct
     public void init(){
       listaCotizacion=cotizacionBO.getAllCotizaciones();  
     }

    public CotizacionBO getCotizacionBO() {
        return cotizacionBO;
    }

    public void setCotizacionBO(CotizacionBO cotizacionBO) {
        this.cotizacionBO = cotizacionBO;
    }

    public List<Cotizacion> getListaCotizacion() {
        return listaCotizacion;
    }

    public void setListaCotizacion(List<Cotizacion> listaCotizacion) {
        this.listaCotizacion = listaCotizacion;
    }
     
}
