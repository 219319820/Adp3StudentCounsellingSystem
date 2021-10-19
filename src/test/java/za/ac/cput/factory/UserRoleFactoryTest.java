/*  UserRoleFactoryTest.java
    Factory Test for User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.factory;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.UserRole;

import static org.junit.jupiter.api.Assertions.*;

public class UserRoleFactoryTest {
    private UserRole userR, userR1, userR2;

   @Test
    void createUserRole() {
     UserRole userR =  UserRoleFactory.createUserRole("Nkanga2021");
     UserRole userR1 = UserRoleFactory.createUserRole("Rafu2020");
       System.out.println(userR);
       System.out.println(userR1);
       assertNotNull(userR);
   }
   @Test
    void objectEquality(){
        userR =  UserRoleFactory.createUserRole("Nkanga2021");
        userR1 = UserRoleFactory.createUserRole( "Rafu2020");
        userR2 = userR;
       assertEquals(userR,userR2);
   }
   @Test
    void objectIdentity(){
       userR =  UserRoleFactory.createUserRole("Nkanga2021");
       userR1 = UserRoleFactory.createUserRole("Rafu2022");
      assertNotSame(userR,userR1);
   }

   @Test
    @Timeout(1000)
   void testTimeout() throws InterruptedException{
       userR =  UserRoleFactory.createUserRole("Nkanga2021");
       Thread.sleep(600);
    }
    @Disabled("Disabled until receptionist is up")
    @Test
    void testDisable(){
        userR =  UserRoleFactory.createUserRole( "Nkanga2021");
        userR1 = UserRoleFactory.createUserRole("Rafu2020");
        userR2 = userR;
        assertEquals(userR,userR2);
    }
}