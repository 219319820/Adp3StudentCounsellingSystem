/*  RoleServiceTest.java
    Service Test for Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */

package za.ac.cput.services;

import org.junit.Test;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;


import static org.junit.jupiter.api.Assertions.*;

public class RoleServiceTest {
    public static RoleService service = RoleService.getService();
    public static Role role =  RoleFactory.createRole("Psychologist");

    @Test
    void a_create() {
        Role created = service.create(role);
        assertEquals(created.getRoleId(), role.getRoleId());
        System.out.println("Create: " + created);
    }
    @Test
    void b_read(){
        Role read = service.read(role.getRoleId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }
    @Test
    void c_update(){
        Role updated = new Role.Builder().copy(role).setRoleDescription("Psychiatrist").build();
        assertNotNull(service.update(updated));
        System.out.println("Update" + updated);
    }
    @Test
    void e_delete(){
        boolean success= service.delete(role.getRoleId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }
    @Test
    void f_getAll(){
        System.out.println("Show All");
        System.out.println(service.getAll());
    }
}