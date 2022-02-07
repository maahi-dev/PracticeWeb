package Entity;

import Entity.TblCustomer;
import Entity.TblDepartment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-05T10:49:18")
@StaticMetamodel(TblEmployee.class)
public class TblEmployee_ { 

    public static volatile SingularAttribute<TblEmployee, String> employeeName;
    public static volatile SingularAttribute<TblEmployee, TblDepartment> departmentId;
    public static volatile SingularAttribute<TblEmployee, Integer> employeeId;
    public static volatile CollectionAttribute<TblEmployee, TblCustomer> tblCustomerCollection;
    public static volatile SingularAttribute<TblEmployee, Integer> salary;

}