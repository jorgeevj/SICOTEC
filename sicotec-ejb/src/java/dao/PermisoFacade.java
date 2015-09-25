/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Permiso;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jorge
 */
@Stateless
public class PermisoFacade extends AbstractFacade<Permiso> {
    @PersistenceContext(unitName = "sicotec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisoFacade() {
        super(Permiso.class);
    }
    
        
    public List<Permiso> permisosByRol(int idRol){
        List<Permiso> permisos = new ArrayList<Permiso>();
        try{
            String sql = "SELECT p.* "+
                         "FROM sicotecBD.permrol pr " +
                         "INNER JOIN sicotecBD.permiso p " +
                         "ON p.idpermiso = pr.idpermiso";
            
            Query query = em.createNativeQuery(sql, Permiso.class);            
            permisos = query.getResultList();
        }catch(Exception e){
            permisos = new ArrayList<Permiso>();
        }
        
        return permisos;
    }
    
}
