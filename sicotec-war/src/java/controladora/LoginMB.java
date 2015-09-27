/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladora;

import bo.PermisoBO;
import bo.UsuarioBO;
import dto.PermisoDTO;
import dto.UsuarioDTO;
import entidades.Permiso;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import Util.Utils;
/**
 *
 * @author Ricardo
 */
@ManagedBean
@SessionScoped
public class LoginMB implements Serializable{

    @EJB
    UsuarioBO usuarioBO = new UsuarioBO();
    @EJB
    PermisoBO permisoBO = new PermisoBO();
    Utils ut = new Utils();
    
    private String nombreUsuario;
    private String contraseña;
    
    //VARIBLES DE SESSION
    //VARIABLES EN SESSION
    private String nombreUsuarioSession;
    private List<PermisoDTO> listaPermisosSession;
    
    public LoginMB() {  
    }
    
    @PostConstruct
    public void init(){
    }
    
    public void loguearse(){
        String nom = getNombreUsuario();
        String con = getContraseña();
        UsuarioDTO u = new UsuarioDTO();
        
        if(nom != null || con != null || !nom.trim().isEmpty() || !con.trim().isEmpty()){
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setNombre(nom);
            usuario.setClave(con);
            
            u = usuarioBO.validateLogin(usuario);
        }
        
        if(u.getIdusuario() != null){
            List<PermisoDTO> listaPermisos = permisoBO.getPermisosByRol(u.getIdRol());
            //DEFINIENDO VARIABLES EN SESSION
            setListaPermisosSession(listaPermisos);
            setNombreUsuarioSession(u.getNombre());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",u);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("permisos",listaPermisos);
            
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (Exception ex) {}
        }else{
            setContraseña("");
            RequestContext.getCurrentInstance().update("contra");
            
            ut.mostrarNotificacion(RequestContext.getCurrentInstance(),"Ingrese usuario/contraseña valido",4000);
            //FacesContext context = FacesContext.getCurrentInstance();
            //context.addMessage(null, new FacesMessage("¿Olvidastes tu contraseña?", "Ingrese un Usuario/Clave valido"));
        }
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the nombreUsuarioSession
     */
    public String getNombreUsuarioSession() {
        return nombreUsuarioSession;
    }

    /**
     * @param nombreUsuarioSession the nombreUsuarioSession to set
     */
    public void setNombreUsuarioSession(String nombreUsuarioSession) {
        this.nombreUsuarioSession = nombreUsuarioSession;
    }

    /**
     * @return the listaPermisosSession
     */
    public List<PermisoDTO> getListaPermisosSession() {
        return listaPermisosSession;
    }

    /**
     * @param listaPermisosSession the listaPermisosSession to set
     */
    public void setListaPermisosSession(List<PermisoDTO> listaPermisosSession) {
        this.listaPermisosSession = listaPermisosSession;
    }
  
}
