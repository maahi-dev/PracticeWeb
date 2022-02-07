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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PracticeSessionBean implements PracticeSessionBeanLocal {

    @PersistenceContext(unitName="PracticeWebPU")
    EntityManager em;
    
    @Override
    public void insertDepartment(String deptName) {
      TblDepartment department= new TblDepartment();
      department.setDepartmentName(deptName);
      em.persist(department);
      
    }

    @Override
    public void updateDepartment(Integer deptId, String departmentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeDepartment(Integer deptId) {
     TblDepartment department=em.find(TblDepartment.class, deptId);
     em.remove(department);
    }

    @Override
    public Collection<TblDepartment> allDepartment() {
        return em.createNamedQuery("TblDepartment.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertEmployee(Integer deptId, String empName, Integer salary) {
     TblDepartment department=em.find(TblDepartment.class, deptId);
       
     Collection<TblEmployee> emp=department.getTblEmployeeCollection();
      
      TblEmployee e = new TblEmployee();
      e.setDepartmentId(department);
      e.setEmployeeName(empName);
      e.setSalary(salary);
      
      emp.add(e);
      department.setTblEmployeeCollection(emp);
      em.persist(e);
      em.merge(department);
    }

    @Override
    public void updateEmployee(Integer empId, Integer deptId, String empName, Integer salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEmployee(Integer empId) {
        TblEmployee emp = em.find(TblEmployee.class, empId);
        TblDepartment dept = em.find(TblDepartment.class, emp.getDepartmentId().getDepartmentId());
//       TblDepartment dept = em.find(TblDepartment.class, deptId);
//       TblEmployee emp= em.find(TblEmployee.class, empId);
//       
       Collection<TblEmployee> employee = dept.getTblEmployeeCollection();
       
       if(employee.contains(emp)){
           employee.remove(emp); 
           dept.setTblEmployeeCollection(employee);
           em.remove(emp);
           em.merge(dept);
       }
    }

    @Override
    public Collection<TblEmployee> getAllEmployee() {
      return em.createNamedQuery("TblEmployee.findAll").getResultList();
    }

    @Override
    public void insertCustomer(String custName, Integer number, String address) {
        TblCustomer customer = new TblCustomer();
        customer.setCustomerName(custName);
        customer.setNumber(number);
        customer.setAddress(address);
        em.persist(customer);
    }

    @Override
    public void updateCustomer(Integer custId, String custName, Integer number, String address) {
       TblCustomer customer =em.find(TblCustomer.class, custId);
       customer.setCustomerName(custName);
       customer.setNumber(number);
       customer.setAddress(address);
       em.merge(customer);
    }

    @Override
    public void removeCustomer(Integer custId) {
       TblCustomer customer= em.find(TblCustomer.class, custId);
       em.remove(customer);
    }

    @Override
    public Collection<TblCustomer> getAllCustomer() {
        return em.createNamedQuery("TblCustomer.findAll").getResultList();
    }

    @Override
    public void addCustomerToEmployee(Integer custId, Collection<Integer> empid) {
       TblCustomer cust = em.find(TblCustomer.class, custId);
       Collection <TblEmployee> emp = cust.getTblEmployeeCollection();
       
       for(int empId : empid){
           TblEmployee employee = em.find(TblEmployee.class, empId);
           if(!emp.contains(employee)){
               Collection<TblCustomer> customer = employee.getTblCustomerCollection();
               customer.add(cust);
               emp.add(employee);
               em.merge(employee);
           }
       }
    }
//     @Override
//    public void addCustomerToEmployee(Integer empId , Collection<Integer> custId) {
//       TblCustomer cust = em.find(TblCustomer.class, custId);
//       Collection <TblEmployee> emp = cust.getTblEmployeeCollection();
//       
//       for(int custid : custId){
//           TblEmployee employee = em.find(TblEmployee.class, empId);
//           if(emp.contains(employee)){
//               Collection<TblCustomer> customer = employee.getTblCustomerCollection();
//               customer.add(cust);
//               emp.add(employee);
//               em.merge(employee);
//           }
//       }
//    }

    @Override
    public void removeCustomerToEmployee(Integer custId, Collection<Integer> empid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
