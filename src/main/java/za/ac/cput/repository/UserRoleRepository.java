/*  UserRoleRepository.java
    Repository for the User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */

package za.ac.cput.repository;

import za.ac.cput.entity.UserRole;

import java.util.HashSet;
import java.util.Set;

public class UserRoleRepository implements IUserRoleRepository {
    public static UserRoleRepository repository = null;
    public Set<UserRole> userRoleDB = null;

    private UserRoleRepository() {
        userRoleDB = new HashSet<UserRole>();
    }

    public static UserRoleRepository getRepository() {
        if (repository == null) {
            repository = new UserRoleRepository();
        }
        return repository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        boolean success = userRoleDB.add(userRole);
        if (!success)
            return null;
        return userRole;
    }

    @Override
    public UserRole read(String roleId) {
        for (UserRole ur : userRoleDB)
            if (ur.getRoleId().equals(roleId)) {
                return ur;
            }
        return null;
    }

    @Override
    public UserRole update(UserRole userRole) {
        UserRole oldUserRole = read(userRole.getRoleId());
        if (oldUserRole != null) {
            userRoleDB.remove(oldUserRole);
            userRoleDB.add(userRole);
            return userRole;
        }
        return null;
    }

    @Override
    public boolean delete(String roleId) {
        UserRole userRoleDeleted = read(roleId);
        if (userRoleDeleted == null) {
            return false;
        }
            return true;
        }

    @Override
    public Set<UserRole> getAll() {
        return userRoleDB;
    }
}