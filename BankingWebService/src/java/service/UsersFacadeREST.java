/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Utils.Constant;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.FormService;
import models.Result;

/**
 *
 * @author hoangminhk4b
 */
@Stateless
@Path("v1/users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "BankingWebServicePU")
    private EntityManager em;
    
    @EJB
    private HistoryFacadeREST historyEJB;

    public UsersFacadeREST() {
        super(Users.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("findByUsername/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users findByUsername(@PathParam("username") String username){
           Query query=em.createNamedQuery("Users.findByUsername");
           query.setParameter("username", username);
           try{
               Users user=(Users) query.getSingleResult();
               return user;
           }catch(Exception e){
               return null;
           }
    }

    @POST
    @Path("sendFormToService")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String sendFormToService(FormService formService) {
        int phiGD = phiGD(formService.getSoTien());
        Result result = new Result();
        result.setHistory(new History(formService.getMaDT(), formService.getMaKH(), formService.getSoTien(), formatDateToTimestamp(),phiGD));
        Users userDT = getNumberCardDT(formService.getMaDT(), formService.getMkDT());
        if (userDT == null) {
            result.setResult(Constant.DT_KHONG_TON_TAI);
            return result.getResult();
        }
        Users userKH = checkCardNumberAndPin(formService.getMaTKKH(), formService.getMaPin(),formService.getMaKH());
        if (userKH == null) {
            result.setResult(Constant.KH_KHONG_TON_TAI);
            return result.getResult();
        }

        int checkMoneyTotal = checkMoneyTotal(userKH.getUsername(),formService.getSoTien(),phiGD);
        if (checkMoneyTotal == Constant.TK_KHONG_TON_TAI) {
            result.setResult(Constant.KH_KHONG_TON_TAI);
            return result.getResult();
        } else if (checkMoneyTotal == Constant.TK_KHONG_DU) {
            result.setResult(Constant.TK_KHONG_DU_GD);
            return result.getResult();
        }
        boolean gd = giaoDich(userDT, userKH, formService.getSoTien(),phiGD);
        if (gd) {
            result.setResult(Constant.GIAO_DICH_THANH_CONG);
            historyEJB.setHistory(result);
            return result.getResult();
        } else {
            result.setResult(Constant.GIAO_DICH_KHONG_THANH_CONG);
            return result.getResult();
        }
    }
    
    @GET
    @Path("checkDtOrKh/{check}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users check(@PathParam("check") String check1){
        Query query=em.createNamedQuery("Users.check");
        query.setParameter("username", check1);
        Users user=(Users) query.getSingleResult();
        return user;
    }

    private int checkMoneyTotal(String user,int money ,int moneyCheck) {
        Query query = em.createNamedQuery("Users.findByUsername");
        query.setParameter("username", user);
        try {
            Users users = (Users) query.getSingleResult();
            int totalMoney=moneyCheck+money;
            if (users.getTotalmoney() > totalMoney) {
                return Constant.TK_DU_GD;
            } else {
                return Constant.TK_KHONG_DU;
            }
        } catch (NumberFormatException e) {
            return Constant.TK_KHONG_TON_TAI;
        }
    }

    private Users getNumberCardDT(String name, String password) {
        Query query = em.createNamedQuery("Users.getCardNumber");
        query.setParameter("username", name);
        query.setParameter("password", password);
        try {
            Users users = (Users) query.getSingleResult();
            return users;
        } catch (Exception e) {
            return null;
        }
    }

    private Users checkCardNumberAndPin(String cardNumber, int Pin, String username) {
        Query query = em.createNamedQuery("Users.checkCardNumber");
        query.setParameter("cardnumber", cardNumber);
        query.setParameter("cardpin", Pin);
        try {
            Users user = (Users) query.getSingleResult();
            if (user.getUsername().equals(username)) {
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    private boolean giaoDich(Users DT, Users KH, int tien,int phiGD) {
        int totalMoneyDT = DT.getTotalmoney() + tien;
        DT.setTotalmoney(totalMoneyDT);
        edit(DT);
        int totalMoneyKH = KH.getTotalmoney() - tien - phiGD;
        KH.setTotalmoney(totalMoneyKH);
        edit(KH);
        return true;
    }

    private int phiGD(int tienGDINT) {
        if (tienGDINT <= 100000) {
            return 10000;
        } else if (tienGDINT > 100000 && tienGDINT <= 500000) {
            return (int) (tienGDINT * 0.02);
        } else if (tienGDINT > 500000 && tienGDINT <= 1000000) {
            return (int) (tienGDINT * 0.015);
        } else if (tienGDINT > 1000000 && tienGDINT <= 5000000) {
            return (int) (tienGDINT * 0.01);
        } else {
            return (int) (tienGDINT * 0.005);
        }
    }

    private String formatDateToTimestamp() {
        long timeMillisecond = new Date().getTime();
        long timeSecond = (long) Math.floor(timeMillisecond / 1000);
        return String.valueOf(timeSecond);
    }

}
