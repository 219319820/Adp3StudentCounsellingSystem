/*  UserRoleServiceTest.java
    Service Test for User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.services;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserRoleServiceTest {
    public static UserRoleService service = UserRoleService.getService();
    public static UserRole userRole = UserRoleFactory.createUserRole("Nkanga0012");

    @Test
    void a_create(){
        UserRole created = service.create(userRole);
        assertEquals(created.getRoleId(), userRole.getRoleId());
        System.out.println("Created: " + created);
    }
    @Test
    void b_read(){
       UserRole read = service.read("Psych2021");
       assertNotNull(read);
        System.out.println("Read" + read);
    }
    @Test
    void c_update(){
       UserRole updated = new UserRole.Builder().copy(userRole).setUserId("Rafu1994").build();
       assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }
    @Test
    void e_delete(){
        boolean success = service.delete(userRole.getRoleId());
        assertTrue(success);
        System.out.println("Delete:" + success);

    }
    @Test
    void f_getAll(){
        System.out.println("Show All");
        System.out.println(service.getAll());
    }
}