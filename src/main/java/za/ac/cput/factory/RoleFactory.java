/*  RoleFactory.java
        * Factory for Role Factory
        *  Author: Vuyisa Nkangana(218192215)
        *  Date: 4 October 2021
        */
package za.ac.cput.factory;

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.entity.Role;

public class RoleFactory {
    public static Role createRole(String roleName,String roleDescription){
        String roleId = GenericHelper.generateId();
        Role role = new Role.Builder()
                .setRoleId(roleId)
                .setRoleName(roleName)
                .setRoleDescription(roleDescription)
                .build();
        return role;
    }

}
