/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:Practice [generic]<br>
 * USAGE:
 * <pre>
 *        PracticeClient client = new PracticeClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author HP
 */
public class PracticeClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/PracticeWeb/webresources";

    public PracticeClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void insertDepartment(String deptName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertDepartment/{0}", new Object[]{deptName})).request().post(null);
    }

    public void updateDepartment(String deptId, String departmentName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateDepartment/{0}/{1}", new Object[]{deptId, departmentName})).request().put(null);
    }

    public <T> T allDepartment(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allDepartment");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeDepartment(String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeDepartment/{0}", new Object[]{deptId})).request().delete();
    }

    public void insertEmployee(String deptId, String empName, String salary) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertEmployee/{0}/{1}/{2}", new Object[]{deptId, empName, salary})).request().post(null);
    }

    public void updateEmployee(String empId, String deptId, String empName, String salary) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateEmployee/{0}/{1}/{2}/{3}", new Object[]{empId, deptId, empName, salary})).request().put(null);
    }

    public void removeEmployee(String empId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeEmployee/{0}", new Object[]{empId})).request().delete();
    }

    public <T> T getAllEmployee(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllEmployee");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
