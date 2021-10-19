/*  IUserRoleRepository.java
    IUserRole Repository for User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */

package za.ac.cput.repository;

import za.ac.cput.entity.UserRole;
import java.util.Set;

public interface IUserRoleRepository extends IRepository<UserRole, String> {
    public Set<UserRole> getAll();
}
