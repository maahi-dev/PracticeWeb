/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import EJB.PracticeSessionBeanLocal;
import Entity.TblCustomer;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author HP
 */

@ManagedBean(name="customerManagedBean")
@SessionScoped
@Dependent
public class CustomerManagedBean {
 @EJB PracticeSessionBeanLocal psb;
 
 Integer custId,number;
 String custName,address;
 private transient Integer row = 0;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRow() {
        return ++row;
    }

//    public void setRow(Integer row) {
//        this.row = row;
//    }
    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
    }
    
    public String insertCustomer(){
        this.psb.insertCustomer(custName, number, address);
        return "";
    }
    
    public String removeCustomer(Integer custId){
        this.psb.removeCustomer(custId);
        return "";
    }
    
    public Collection<TblCustomer> allCustomer(){
        return this.psb.getAllCustomer();
    }
    
}
