/*  RoleRepository.java
   RepositoryTest for Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.repository;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class RoleRepositoryTest {
    private static RoleRepository repository = RoleRepository.getRepository();
    private static Role role = RoleFactory.createRole("Psychiatrist");

    @Test
    void a_create(){
        Role created = repository.create(role);
        assertEquals(created.getRoleId(),role.getRoleId());
        System.out.println("Create:" + created);
    }
    @Test
    void b_read(){
        Role read = repository.read(role.getRoleId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }
    @Test
    void c_update(){
        Role updated = new Role.Builder().copy(role).setRoleDescription("Psychiatrist").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update:" + updated);
    }
    @Test
    void e_delete(){
        boolean success = repository.delete(role.getRoleId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }
    @Test
    void f_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}