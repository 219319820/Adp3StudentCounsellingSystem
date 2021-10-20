package za.ac.cput.controlller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.services.UserRoleService;

import java.util.Set;

@RestController
@RequestMapping
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserRole create(@RequestBody UserRole userRole){
        UserRole newUserRole = UserRoleFactory.createUserRole(userRole.getUserId());
        return userRoleService.create(newUserRole);
    }
    @GetMapping("/read/{roleId}")
    public UserRole read(@PathVariable String roleId){
        return userRoleService.read(roleId);
    }
    @PostMapping("/update")
    public UserRole update(@RequestBody UserRole userRole){
        return userRoleService.update(userRole);
    }
    @DeleteMapping("/delete/roleId")
    public boolean delete(@PathVariable String roleId){
        return userRoleService.delete(roleId);
    }
    @GetMapping("/getAll")
    public Set<UserRole> getAll(){
        return userRoleService.getAll();
    }
    @GetMapping("/getallwithu")
    public Set<UserRole>getAllWithu(){
        return userRoleService.getAllUserRoleStartsWithU();
    }

}
