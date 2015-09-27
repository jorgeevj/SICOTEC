/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora;

import controladora.TipoItem.*;
import controladora.Movimiento.*;
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
public class tipoitemMB {
    private String nombre;
    
    public void guardar(){
        System.out.println("APRETO!"); 
        //ut.mostrarNotificacion(RequestContext.getCurrentInstance(), "holi", 1000);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
