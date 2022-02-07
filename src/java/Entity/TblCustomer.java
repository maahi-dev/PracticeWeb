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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "tbl_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCustomer.findAll", query = "SELECT t FROM TblCustomer t"),
    @NamedQuery(name = "TblCustomer.findByCustomerId", query = "SELECT t FROM TblCustomer t WHERE t.customerId = :customerId"),
    @NamedQuery(name = "TblCustomer.findByNumber", query = "SELECT t FROM TblCustomer t WHERE t.number = :number")})
public class TblCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "customer_name")
    private String customerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @JoinTable(name = "tbl_contact", joinColumns = {
        @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")}, inverseJoinColumns = {
        @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")})
    @ManyToMany
    private Collection<TblEmployee> tblEmployeeCollection;

    public TblCustomer() {
    }

    public TblCustomer(Integer customerId) {
        this.customerId = customerId;
    }

    public TblCustomer(Integer customerId, String customerName, int number, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.number = number;
        this.address = address;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblEmployee> getTblEmployeeCollection() {
        return tblEmployeeCollection;
    }

    public void setTblEmployeeCollection(Collection<TblEmployee> tblEmployeeCollection) {
        this.tblEmployeeCollection = tblEmployeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCustomer)) {
            return false;
        }
        TblCustomer other = (TblCustomer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblCustomer[ customerId=" + customerId + " ]";
    }
    
}
