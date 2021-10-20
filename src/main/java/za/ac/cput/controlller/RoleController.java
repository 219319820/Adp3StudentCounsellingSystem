package za.ac.cput.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;
import za.ac.cput.services.RoleService;

import java.util.Set;

@RestController
@RequestMapping("/role")
public class RoleController {

@Autowired
    private RoleService roleService;

@PostMapping("/create")
    public Role create(@RequestBody Role role) {
    Role newRole = RoleFactory.createRole(role.getRoleName(), role.getRoleDescription());
    return roleService.create(newRole);
}

    @GetMapping("/read/{Id}")
            public Role read(@PathVariable String roleId){
        return roleService.read(roleId);
    }
    @PostMapping ("/update")
    public Role update(@RequestBody Role role){
    return roleService.update(role);
}
@DeleteMapping("/{roleId}")
    public boolean delete(@PathVariable String roleId){
    return roleService.delete(roleId);
}
@GetMapping("/getAll")
    public Set<Role>getAll(){
    return roleService.getAll();
}
@GetMapping("/getAllwitha")
    public Set<Role>getAllWitha(){
    return roleService.getAllRoleStartingWithA();
}
}
