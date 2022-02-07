/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tbl_department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartment.findAll", query = "SELECT t FROM TblDepartment t"),
    @NamedQuery(name = "TblDepartment.findByDepartmentId", query = "SELECT t FROM TblDepartment t WHERE t.departmentId = :departmentId")})
public class TblDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "department_id")
    private Integer departmentId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private Collection<TblEmployee> tblEmployeeCollection;

    public TblDepartment() {
    }

    public TblDepartment(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public TblDepartment(Integer departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartment)) {
            return false;
        }
        TblDepartment other = (TblDepartment) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblDepartment[ departmentId=" + departmentId + " ]";
    }
    
}
