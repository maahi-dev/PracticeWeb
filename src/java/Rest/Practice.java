/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import EJB.PracticeSessionBeanLocal;
import Entity.TblDepartment;
import Entity.TblEmployee;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("generic")
public class Practice {

    @EJB
    PracticeSessionBeanLocal psb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Practice
     */
    public Practice() {
    }

    @POST
    @Path("insertDepartment/{deptName}")
    public void insertDepartment(@PathParam("deptName") String deptName) {
        psb.insertDepartment(deptName);

    }

    @PUT
    @Path("updateDepartment/{deptId}/{departmentName}")
    public void updateDepartment(@PathParam("deptId") Integer deptId, @PathParam("departmentName") String departmentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @DELETE
    @Path("removeDepartment/{deptId}")
    public void removeDepartment(@PathParam("deptId") Integer deptId) {
        psb.removeDepartment(deptId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allDepartment")
    public Collection<TblDepartment> allDepartment() {
        return psb.allDepartment();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @POST
    @Path("insertEmployee/{deptId}/{empName}/{salary}")
    public void insertEmployee(@PathParam("deptId") Integer deptId, @PathParam("empName") String empName, @PathParam("salary") Integer salary) {
        psb.insertEmployee(deptId, empName, salary);
    }

    @PUT
    @Path("updateEmployee/{empId}/{deptId}/{empName}/{salary}")
    public void updateEmployee(@PathParam("empId") Integer empId, @PathParam("deptId") Integer deptId, @PathParam("empName") String empName, @PathParam("salary") Integer salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @DELETE
    @Path("removeEmployee/{empId}")
    public void removeEmployee(@PathParam("empId") Integer empId) {
        psb.removeEmployee(empId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllEmployee")
    public Collection<TblEmployee> getAllEmployee() {
        return psb.getAllEmployee();
    }
}
