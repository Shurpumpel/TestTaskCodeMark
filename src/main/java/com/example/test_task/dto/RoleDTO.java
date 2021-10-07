package com.example.test_task.dto;

import com.example.test_task.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO {
    @JsonProperty("role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static RoleDTO fromModel(Role role){
        RoleDTO dto = new RoleDTO();
        dto.setRole(role.getRole());
        return dto;
    }
}
