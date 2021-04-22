package com.myForum.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myForum.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse extends Response{

    private Role role;
    private List<Role> roles;
    private Long roleId;

    public RoleResponse(String msg, Role role) {
        super(msg);
        this.role = role;
    }

    public RoleResponse(String msg, List<Role> roles) {
        super(msg);
        this.roles = roles;
    }

    public RoleResponse(String msg, Long roleId) {
        super(msg);
        this.roleId = roleId;
    }
}
