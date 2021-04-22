package com.myForum.services.interfaces;

import com.myForum.models.Role;
import com.myForum.requests.RoleRequest;

import java.util.List;

public interface IRoleService {

    //a list with all the roles
    List<Role> getAll();

    //role found by the given id
    Role getById(Long roleId);

    //create a new role
    boolean newRole(RoleRequest request);

    //update role with the given id
    Role updateRole(Long roleId, RoleRequest request);

    //delete an role with the given id
    boolean deleteRole(Long roleId);
}
