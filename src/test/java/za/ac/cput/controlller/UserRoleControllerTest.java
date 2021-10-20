package za.ac.cput.controlller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;

import java.net.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironMent.RANDOM_PORT)

class UserRoleControllerTest {
    private static UserRole userRole1 = UserRoleFactory.createUserRole("Psych2021");
    private static UserRole userRole3 = UserRoleFactory.createUserRole("Psy2019");
    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String baseURL = "http://localhost:8080/userRole";

    private String username = "user";
    private String password = "password";

    void a_create01() {
        String url = baseURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<UserRole> httpEntity = new HttpEntity<>(userRole1, httpHeaders);
        ResponseEntity<UserRole> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity, UserRole.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        userRole1 = responseEntity.getBody();
        System.out.println("Saved Data " + userRole1);
        assertEquals(userRole1.getRoleId(), responseEntity.getBody().getRoleId());

    }
    @Test
    void b_create02() {
        String url = baseURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<UserRole> httpEntity = new HttpEntity<>(userRole3, httpHeaders);
        ResponseEntity<UserRole> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, UserRole.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        userRole3 = responseEntity.getBody();
        System.out.println("Saved Data " + userRole3);
        assertEquals(userRole3.getRoleId(), responseEntity.getBody().getRoleId());
    }

    @Test
    void c_read() {
        UserRole u = null;
        String url = baseURL + "/read/" +userRole3.getRoleId();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<UserRole> request = new HttpEntity<>(u, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<UserRole> responseCreate = restTemplate.postForEntity(url, request, UserRole.class);
        assertNotNull(userRole3.getRoleId(), responseCreate.getBody().getRoleId());
    }

    @Test
    void d_update(){
       UserRole update = new UserRole.Builder().copy(userRole1).setUserId("Stud2018").build();
        String url = baseURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<UserRole> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the item: " + url);
        System.out.println("Updated Item: "+ update);
        ResponseEntity<UserRole> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,UserRole.class);
        assertNotNull(responseUpdate.getBody());
    }

    @Test
    void f_delete(){
        String url = baseURL + "/delete" + userRole1.getRoleId();
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