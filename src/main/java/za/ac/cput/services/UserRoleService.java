/*  UserRoleService.java
    Service for the User Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Role;
import za.ac.cput.entity.UserRole;
import za.ac.cput.repository.RoleRepository;
import za.ac.cput.repository.UserRoleRepository;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleService implements IUserRoleService {
    private static UserRoleService service = null;

    @Autowired
    private UserRoleRepository repository;

    @Override
    public UserRole create(UserRole userRole) {
        return this.repository.save(userRole);
    }

    @Override
    public UserRole read(String roleId) {
        return this.repository.findById(roleId).orElse(null);
    }

    @Override
    public UserRole update(UserRole userRole) {
        if(this.repository.existsById(userRole.getRoleId()))
            return this.repository.save(userRole);
        return null;
    }

    @Override
    public boolean delete(String roleId) {
        this.repository.deleteById(roleId);
        if (this.repository.existsById(roleId))
            return false;
        else
            return true;
    }

    @Override
    public Set<UserRole> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Set<UserRole> getAllUserRoleStartsWithU(){
        Set<UserRole> userRoleWithU = new HashSet<>();
        Set<UserRole> userRoles = getAll();
        for(UserRole userRole : userRoles){
            if(userRole.getUserId().trim().toLowerCase().startsWith("u")){
                userRoleWithU.add(userRole);
            }
        }
        return userRoleWithU;
    }

    public UserRole getUserRoleGivenUserId(String userId) {
        UserRole u = null;
        Set<UserRole>userRoles = getAll();
        for(UserRole userRole : userRoles){
            if(userRole.getUserId().equals(userId)){
                u = userRole;
                break;
            }
        }
        return u;
    }
    }

