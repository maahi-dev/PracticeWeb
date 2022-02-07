/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmployee.findAll", query = "SELECT t FROM TblEmployee t"),
    @NamedQuery(name = "TblEmployee.findByEmployeeId", query = "SELECT t FROM TblEmployee t WHERE t.employeeId = :employeeId"),
    @NamedQuery(name = "TblEmployee.findBySalary", query = "SELECT t FROM TblEmployee t WHERE t.salary = :salary")})
public class TblEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "employee_name")
    private String employeeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private int salary;
    @ManyToMany(mappedBy = "tblEmployeeCollection")
    private Collection<TblCustomer> tblCustomerCollection;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private TblDepartment departmentId;

    public TblEmployee() {
    }

    public TblEmployee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public TblEmployee(Integer employeeId, String employeeName, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblCustomer> getTblCustomerCollection() {
        return tblCustomerCollection;
    }

    public void setTblCustomerCollection(Collection<TblCustomer> tblCustomerCollection) {
        this.tblCustomerCollection = tblCustomerCollection;
    }

    public TblDepartment getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(TblDepartment departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmployee)) {
            return false;
        }
        TblEmployee other = (TblEmployee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblEmployee[ employeeId=" + employeeId + " ]";
    }
    
}
