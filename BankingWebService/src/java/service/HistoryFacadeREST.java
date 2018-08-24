/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Utils.Constant;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import models.HistoryConvert;
import models.LoginHistory;
import models.Result;

/**
 *
 * @author hoangminhk4b
 */
@Stateless
@Path("v1/history")
public class HistoryFacadeREST extends AbstractFacade<History> {

    @PersistenceContext(unitName = "BankingWebServicePU")
    private EntityManager em;
    
    @EJB
    private UsersFacadeREST userEJB;

    public HistoryFacadeREST() {
        super(History.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     *
     * @param result
     * @return
     */
    public boolean setHistory(Result result){
        if(result.getResult().equals(Constant.GIAO_DICH_THANH_CONG)){
            super.create(result.getHistory());
            return true;
        }
        return false;
    }
    
    @POST
    @Path("getHistory")
    public List<HistoryConvert> getHistory(LoginHistory login){
        Users user=userEJB.check(login.getUsername());
        boolean checkUser=user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword());
        boolean checkCard=user.getCardnumber().equals(login.getUsername()) && user.getCardpin() == Integer.parseInt(login.getPassword());
        List<History> resultUsername=getHistoryByUsername(user.getUsername());
        List<HistoryConvert> resultConvert=new ArrayList<>();
        if(checkUser || checkCard){
            for(History h:resultUsername){
                int time=Integer.parseInt(h.getNgayGD());
                if(login.getTimeStart()<= time && time <= login.getTimeEnd()){
                    HistoryConvert hc=setHistoryConvertByUser(h,user,login.getUsername());
                    resultConvert.add(hc);
                }
            }
            return resultConvert;
        }
        
        return resultConvert;
    }
    
    private List<History> getHistoryByUsername(String username){
        Query query=em.createNamedQuery("History.findByUsername");
        query.setParameter("maKH", username);
        List<History> result=query.getResultList();
        return result;
    }
    
    private HistoryConvert setHistoryConvertByUser(History h,Users user,String username){
                HistoryConvert hc=new HistoryConvert();
                hc.setUsername(username);
                hc.setPhiGD(h.getPhiGD());
                hc.setNgayGD(h.getNgayGD());
                if(h.getMaDT().equals(user.getUsername())){
                    hc.setSoTien("+"+h.getSoTien());
                }else{
                    hc.setSoTien("-"+h.getSoTien());
                }
                return hc;
    }
    
}
