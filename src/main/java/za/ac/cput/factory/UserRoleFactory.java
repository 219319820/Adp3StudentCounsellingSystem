/*  UserRoleFactory.java
    Factory for User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */

package za.ac.cput.factory;

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.entity.UserRole;

public class UserRoleFactory {
    public static UserRole createUserRole(String userId ){
        String roleId = GenericHelper.generateId();
        UserRole userrole = new UserRole.Builder()
                .setRoleId(roleId)
                .setUserId(userId)
                .build();
        return userrole;

    }

}
