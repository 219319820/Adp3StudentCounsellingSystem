package za.ac.cput.controlller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Role;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.RoleFactory;
import za.ac.cput.factory.UserRoleFactory;

import java.net.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironMent.RANDOM_PORT)
class RoleControllerTest {

    private static Role role1 = RoleFactory.createRole("Student", "Stud2018");
    private static Role role3 = RoleFactory.createRole("Psychiatrist","Psyc2021");

    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String baseURL = "http://localhost:8080/userRole";

    private String username = "user";
    private String password = "password";

    void a_create01() {
        String url = baseURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Role> httpEntity = new HttpEntity<>(role1, httpHeaders);
        ResponseEntity<Role> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity, Role.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        role1 = responseEntity.getBody();
        System.out.println("Saved Data " + role1);
        assertEquals(role1.getRoleId(), responseEntity.getBody().getRoleId());

    }
    @Test
    void b_create02() {
        String url = baseURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<UserRole> httpEntity = new HttpEntity<>(role3, httpHeaders);
        ResponseEntity<UserRole> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Role.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        role3 = responseEntity.getBody();
        System.out.println("Saved Data " + role3);
        assertEquals(role3.getRoleId(), responseEntity.getBody().getRoleId());
    }

    @Test
    void c_read() {
        UserRole u = null;
        String url = baseURL + "/read/" + role3.getRoleId();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<UserRole> request = new HttpEntity<>(u, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<UserRole> responseCreate = restTemplate.postForEntity(url, request, Role.class);
        assertNotNull(role3.getRoleId(), responseCreate.getBody().getRoleId());
    }


    @Test
    void d_update(){
        Role update = new Role.Builder().copy(role1).setRoleId("Stud3030").build();
        String url = baseURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Role> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the item: " + url);
        System.out.println("Updated Item: "+ update);
        ResponseEntity<UserRole> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Role.class);
        assertNotNull(responseUpdate.getBody());
    }

    @Test
    void f_delete(){
        String url = baseURL + "/delete" + role1.getRoleId();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll(){
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                //basic config
                .withBasicAuth("user","password")
                .exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("show the entries made");
        System.out.println(response);
        System.out.println(response.getBody());

    }

}