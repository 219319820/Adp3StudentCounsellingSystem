/* IRoleService.java
 * Repository for Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.services;

import za.ac.cput.entity.Role;

import java.util.Set;

public interface IRoleService extends IService<Role, String> {
    Set<Role>getAll();
    public Role getRoleGivenDescription(String description);

}
