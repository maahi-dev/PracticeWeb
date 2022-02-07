/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.TblCustomer;
import Entity.TblDepartment;
import Entity.TblEmployee;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PracticeSessionBeanLocal {
    public void insertDepartment(String deptName);
    public void updateDepartment(Integer deptId, String departmentName);
    public void removeDepartment(Integer deptId);
    Collection<TblDepartment> allDepartment();
    
    public void insertEmployee(Integer deptId, String empName,Integer salary);
    public void updateEmployee(Integer empId, Integer deptId, String empName,Integer salary);
    public void removeEmployee(Integer empId);
    Collection<TblEmployee> getAllEmployee();
    
    public void insertCustomer(String custName,Integer number, String address);
    public void updateCustomer(Integer custId,String custName,Integer number, String address);
    public void removeCustomer(Integer custId);
    Collection<TblCustomer> getAllCustomer();
    
    public void addCustomerToEmployee(Integer custId , Collection<Integer> empid);
//    public void addCustomerToEmployee(Integer empId , Collection<Integer> custId);
    public void removeCustomerToEmployee(Integer custId , Collection<Integer> empid);
    
}
