/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hoangminhk4b
 */
@Stateless
@Path("admin")
public class AdminFacadeREST extends AbstractFacade<Users>{
    
    @PersistenceContext(unitName = "BankingWebServicePU")
    private EntityManager em;

    public AdminFacadeREST() {
        super(Users.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
