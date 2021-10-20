/* RoleService.java
 * Service for Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */
package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Role;
import za.ac.cput.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {
    private static RoleService service = null;

    @Autowired
    private RoleRepository repository;

    @Override
    public Role create(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Role read(String roleId) {
        return this.repository.findById(roleId).orElse(null);
    }

    @Override
    public Role update(Role role) {
        if (this.repository.existsById(role.getRoleId()))
            return this.repository.save(role);
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
    public Set<Role> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Role getRoleGivenDescription(String roleDescription) {
        Role r = null;
        Set<Role>roles = getAll();
        for(Role role : roles){
            if(role.getRoleDescription().equals(roleDescription)){
                r = role;
                break;
            }
        }
        return r;
    }

    public Set<Role> getAllRoleStartingWith() {
        Set<Role> roleWithA = new HashSet<>();
        Set<Role> roles = getAll();
        for (Role role : roles) {
            if (role.getRoleDescription().trim().toLowerCase().startsWith("a")) {
                roleWithA.add(role);
            }
        }
return roleWithA;
    }
}

