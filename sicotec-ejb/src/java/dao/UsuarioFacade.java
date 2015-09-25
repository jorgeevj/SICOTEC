/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UsuarioDTO;
import entidades.Permiso;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author Jorge
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "sicotec-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario validateLogin(UsuarioDTO usuario){
        Usuario u = new Usuario();
        try{
            String jpa = "SELECT u "
                       + "FROM Usuario u "
                       + "WHERE u.nombre = :nombre "
                       + "AND   u.clave  = :clave";

            Query query = em.createQuery(jpa,Usuario.class);
            query.setParameter("nombre",usuario.getNombre());
            query.setParameter("clave",usuario.getClave());

            u = (Usuario)query.getSingleResult();
            
        }catch(Exception e){
            u = new Usuario();
        }
        
        return u;
    }
}
