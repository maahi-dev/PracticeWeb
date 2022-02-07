package Entity;

import Entity.TblEmployee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-05T10:49:18")
@StaticMetamodel(TblDepartment.class)
public class TblDepartment_ { 

    public static volatile SingularAttribute<TblDepartment, String> departmentName;
    public static volatile CollectionAttribute<TblDepartment, TblEmployee> tblEmployeeCollection;
    public static volatile SingularAttribute<TblDepartment, Integer> departmentId;

}