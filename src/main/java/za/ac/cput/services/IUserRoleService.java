/* IUserRoleRepository.java
 * IRepository for UserRole
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.services;

import za.ac.cput.entity.Role;
import za.ac.cput.entity.UserRole;

import java.util.Set;

public interface IUserRoleService extends IService<UserRole, String>{

    Set<UserRole> getAll();
    public UserRole getUserRoleGivenUserId(String userId);
}
