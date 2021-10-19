/*  UserRoleRepositoryTest.java
    Repository Test for User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.repository;

import org.junit.Test;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;

import static org.junit.jupiter.api.Assertions.*;

public class UserRoleRepositoryTest {
    private static UserRoleRepository repository = UserRoleRepository.getRepository();
    private static UserRole userRole = UserRoleFactory.createUserRole("Nka2021");

    @Test
    void a_create(){
        UserRole created = repository.create(userRole);
        assertEquals(created.getRoleId(),userRole.getUserId());
        System.out.println("Create:" + created);
    }
    @Test
    void b_read(){
        UserRole read = repository.read(userRole.getRoleId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }
    @Test
    void c_update(){
        UserRole updated = new UserRole.Builder().copy(userRole).setUserId("Nkanga2021").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update:" + updated);
    }
    @Test
    void e_delete(){
        boolean success = repository.delete(userRole.getRoleId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }
    @Test
    void f_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}