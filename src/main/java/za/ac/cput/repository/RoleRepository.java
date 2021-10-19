/*  RoleRepository.java
     Repository for Role
 *  Author: Vuyisa Nkangana(218192215)
 *  Date: 4 October 2021
 */


package za.ac.cput.repository;
import za.ac.cput.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class RoleRepository implements IRoleRepository {
    public static RoleRepository repository = null;;
    public Set<Role> roleDB = null;

        private RoleRepository() {
            roleDB = new HashSet<Role>();
        }

        public static RoleRepository getRepository(){
            if(repository == null) {
                repository = new RoleRepository();
            }
            return repository;
        }

    @Override
    public Role create(Role role) {
        boolean success = roleDB.add(role);
        if(!success){
            return null;
        }
        return role;
    }

    @Override
    public Role read(String s) {
     for(Role r : roleDB) {
     }
        return null;
    }

    @Override
    public Role update(Role role) {
            Role oldRole = read(role.getRoleId());
            if(oldRole != null){
                roleDB.remove(oldRole);
                roleDB.add(role);
                        return role;
            }
        return null;
    }
    @Override
    public boolean delete(String roleId) {
        Role RoleToDelete = read(roleId);
        if(RoleToDelete == null){
            return false;
        }
        return true;
    }

    @Override
    public Set<Role> getAll() {
        return roleDB;
    }

}