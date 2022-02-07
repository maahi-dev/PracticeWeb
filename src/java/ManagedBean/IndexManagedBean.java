/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.TblUser;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@Named(value = "")
@ManagedBean(name = "indexManagedBean")
@SessionScoped
@Dependent
public class IndexManagedBean {
    private String username,password,msg;
    @PersistenceContext(unitName="PracticeWebPU")
    EntityManager em;
    /**
     * Creates a new instance of IndexManagedBean
     */
    public IndexManagedBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
//    public String Login() throws SQLException{
//        try{
//            TblUser user = (TblUser)em.createNamedQuery("TblUser.findByUserName").setParameter("username", username).getSingleResult();
//            
//            if((user != null) && user.getPassword().equals(password)){
//                HttpSession objHttpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//                objHttpSession.setAttribute(username, username);
//                return "/Department.jsf?faces-reidrect=true";
//            }
//            else
//            {
//                msg="username/password is incorrect";
//            }
//        }
//        catch(Exception e){
//        msg="username/password is incorrect";
//    }
//    return null;
//    }
     public String Login() throws SQLException {
        try {
            TblUser user = (TblUser) em.createNamedQuery("TblUser.findbyUsername").setParameter("username", username).getSingleResult();

            if ((user != null) && user.getPassword().equals(password)) {
                HttpSession objHttpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                objHttpSession.setAttribute("username", username);
                return "Department.jsf?faces-redirect=true";
            }else{
                msg = "Username and/or password is incorrect";
            }

        } catch (Exception e) {
            msg = "Username and/or password is incorrect";
        }
        return null;
    }
    
}
