/* RoleFactory.java
 * Factory for Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.factory;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Role;

import static org.junit.jupiter.api.Assertions.*;

public class RoleFactoryTest {
    private Role role, role1, role2;

    @Test
    void createRole(){
        Role role = RoleFactory.createRole("Psychiatrist");
        Role role1 = RoleFactory.createRole( "Psychologist");
        System.out.println(role);
        System.out.println(role1);
        assertNotNull(role);
    }
    @Test
    void objectEquality(){
        role = RoleFactory.createRole( "Psychiatrist");
        role1 = RoleFactory.createRole( "Psychologist");
        role2 =role;
        assertEquals(role,role2);
    }
    @Test
    void objectIdentity(){
        role = RoleFactory.createRole( "Psychiatrist");
        role1 = RoleFactory.createRole( "Psychologist");
        assertNotSame(role, role1);
    }
    @Test
    @Timeout(1000)
        void testTimeouts()throws InterruptedException{
        role = RoleFactory.createRole("Psychiatrist");
        Thread.sleep(600);

        }
        @Disabled("Disabled until receptionist is up")
    @Test
    void testDisable(){
            role = RoleFactory.createRole("Psychiatrist");
            role1 = RoleFactory.createRole( "Psychologist");
            role2 =role;
            assertEquals(role, role2);
        }

}