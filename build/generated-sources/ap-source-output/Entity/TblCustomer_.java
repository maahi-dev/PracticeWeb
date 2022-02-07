package Entity;

import Entity.TblEmployee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-05T10:49:18")
@StaticMetamodel(TblCustomer.class)
public class TblCustomer_ { 

    public static volatile SingularAttribute<TblCustomer, Integer> number;
    public static volatile SingularAttribute<TblCustomer, String> address;
    public static volatile CollectionAttribute<TblCustomer, TblEmployee> tblEmployeeCollection;
    public static volatile SingularAttribute<TblCustomer, Integer> customerId;
    public static volatile SingularAttribute<TblCustomer, String> customerName;

}