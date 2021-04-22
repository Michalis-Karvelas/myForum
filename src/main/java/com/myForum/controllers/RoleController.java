package com.myForum.controllers;

import com.myForum.models.Role;
import com.myForum.requests.RoleRequest;
import com.myForum.responses.Response;
import com.myForum.responses.RoleResponse;
import com.myForum.services.RoleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping(value = "/getall")
    public RoleResponse getAll(){
        log.info("Controller: Ready to find all the roles");
        return new RoleResponse("Found all the roles: ", roleService.getAll());
    }

    @GetMapping(value = "/getbyid/{roleId}")
    public RoleResponse getById(@PathVariable(value = "roleId") Long roleId){
        log.info("Controller: Ready to find the role with id: {}",roleId);
        return new RoleResponse("Found the role: ", roleService.getById(roleId));
    }

    @PostMapping(value = "/new",consumes = "application/json",produces = "application/json")
    public Response createNewRole(@RequestBody RoleRequest request){
        log.info("Controller: Ready to create a role");
        roleService.newRole(request);
        log.info("The role has been saved");
        return new Response("The new role has been inserted into the DB");
    }

    @PutMapping(value = "/update/{roleId}", consumes = "application/json", produces = "application/json")
    public Response updateExistingRole(@PathVariable(value = "roleId") Long roleId,@RequestBody RoleRequest request){
        log.info("Controller: Ready to update the role with id: {}",roleId);
        Role role= roleService.updateRole(roleId,request);
        if(isNull(role)){
            return new Response("The role couldn't be updated");
        }
        return new Response("The role has been updated successfully");
    }

    @DeleteMapping(value = "/delete/{roleId}")
    public Response deleteRole(@PathVariable (value = "roleId") Long roleId){
        log.info("Controller: Ready to delete a role with id : {}", roleId);
        if(roleService.deleteRole(roleId)==false){
        return new  Response("The role couldn't be deleted");
        }
        return new Response("The role has been successfully deleted");
    }
}
