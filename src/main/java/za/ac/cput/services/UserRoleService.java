/*  UserRoleService.java
    Service for the User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.services;

import za.ac.cput.entity.UserRole;
import za.ac.cput.repository.UserRoleRepository;

import java.util.Set;

public class UserRoleService implements IUserRoleService {
    private static UserRoleService service = null;
    private UserRoleRepository repository = null;

    private UserRoleService(){
        this.repository = UserRoleRepository.getRepository();
    }
    public static UserRoleService getService(){
        if(service == null){
            service =new UserRoleService();
        }
        return service;
    }


    @Override
    public UserRole read(String roleId) {
        return this.repository.read(roleId);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return this.repository.update(userRole);
    }

    @Override
    public boolean delete(String roleId) {

        return this.repository.delete(roleId);
    }

    @Override
    public UserRole create(UserRole userRole) {
        return this.repository.create(userRole);
    }

    @Override
    public Set<UserRole> getAll() {
        return this.repository.getAll();
    }
}
