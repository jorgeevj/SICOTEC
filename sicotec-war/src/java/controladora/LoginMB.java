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
    
    private String nombreUsuario;
    private String contraseña;
    private List<PermisoDTO> listaPermisos;
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
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",u);
            List<PermisoDTO> listaPermisos = permisoBO.getPermisosByRol(u.getIdRol());
            setListaPermisos(listaPermisos);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("permisos",listaPermisos);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (Exception ex) {}
        }else{
            setContraseña("");
            RequestContext.getCurrentInstance().update("contra");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("¿Olvidastes tu contraseña?", "Ingrese un Usuario/Clave valido"));
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
     * @return the listaPermisos
     */
    public List<PermisoDTO> getListaPermisos() {
        return listaPermisos;
    }

    /**
     * @param listaPermisos the listaPermisos to set
     */
    public void setListaPermisos(List<PermisoDTO> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }
    
    
}
