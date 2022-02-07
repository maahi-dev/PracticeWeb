/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;


import EJB.PracticeSessionBeanLocal;
import Entity.TblEmployee;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 */

@ManagedBean(name="employeeManagedBean")
@SessionScoped
@Dependent
public class EmployeeManagedBean {
    @EJB PracticeSessionBeanLocal psb;
    
    Integer deptId,EmpId,salary;
    private transient Integer row = 0;
    
    public String Hi(){
        System.out.println("Hello");
        return "";
    }

    public Integer getRow() {
        return ++row;
    }

    public PracticeSessionBeanLocal getPsb() {
        return psb;
    }

    public void setPsb(PracticeSessionBeanLocal psb) {
        this.psb = psb;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getEmpId() {
        return EmpId;
    }

    public void setEmpId(Integer EmpId) {
        this.EmpId = EmpId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
    String empName;

    /**
     * Creates a new instance of EmployeeManagedBean
     */
    public EmployeeManagedBean() {
        
    }
    
    public String insertEmployee(){
        this.psb.insertEmployee(deptId, empName, salary);
        return "/ViewEmployee.jsf?faces-redirect=true";
    }
    
    public Collection<TblEmployee> allEmployee(){
        return this.psb.getAllEmployee();
    }
    
      public String removeEmployee(Integer empId){
//          System.out.println(empId);
        this.psb.removeEmployee(empId);
        return"";
    }
    
}
