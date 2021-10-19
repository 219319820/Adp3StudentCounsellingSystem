/* IRoleRepository.java
 * IRepository for Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.repository;
import za.ac.cput.entity.Role;

import java.util.Set;

public interface IRoleRepository extends IRepository<Role, String> {
        public Set<Role> getAll();
}
