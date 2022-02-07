/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Client.PracticeClient;
import EJB.PracticeSessionBeanLocal;
import Entity.TblDepartment;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@ManagedBean(name = "departmentManagedBean")
@SessionScoped
@Dependent

public class DepartmentManagedBean {

    @EJB
    PracticeSessionBeanLocal psb;
    PracticeClient pc = new PracticeClient();
    Response res;
    Collection<TblDepartment> dept;
    GenericType<Collection<TblDepartment>> gdept;

    String departmentName;
    Integer deptId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public PracticeSessionBeanLocal getPsb() {
        return psb;
    }

    public void setPsb(PracticeSessionBeanLocal psb) {
        this.psb = psb;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Creates a new instance of DepartmentManagedBean
     */
    public DepartmentManagedBean() {
    }

    public String insertDepartment() {
//        this.psb.insertDepartment(departmentName);
        this.pc.insertDepartment(this.departmentName);
        return "/Employee.jsf?faces-redirect=true";
    }

    public Collection<TblDepartment> allDepartment() {

        gdept = new GenericType<Collection<TblDepartment>>() {};
        res = pc.allDepartment(Response.class);
        dept = res.readEntity(gdept);
        return dept;
//        return psb.allDepartment();
        
    }

    public String removeDepartment(Integer deptId) {
//        this.psb.removeDepartment(deptId);
          this.pc.removeDepartment(deptId.toString());
        return "";
    }

}
