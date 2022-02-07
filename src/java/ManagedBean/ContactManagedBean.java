/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import EJB.PracticeSessionBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author HP
 */
@ManagedBean(name="contactManagedBean")
@SessionScoped
@Dependent
public class ContactManagedBean {
    @EJB PracticeSessionBeanLocal psb;
    
    Integer custId,empId ;

    public PracticeSessionBeanLocal getPsb() {
        return psb;
    }

    public void setPsb(PracticeSessionBeanLocal psb) {
        this.psb = psb;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * Creates a new instance of ContactManagedBean
     */
    public ContactManagedBean() {
    }
    

    public String addCustomertoEmployee(){
        Collection<Integer> Ids = new ArrayList();
        this.psb.addCustomerToEmployee(custId, Ids);
        return "";
    }
    
}
