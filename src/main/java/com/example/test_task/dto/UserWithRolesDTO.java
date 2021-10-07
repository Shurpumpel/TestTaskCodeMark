package com.example.test_task.dto;

import com.example.test_task.entity.Role;
import com.example.test_task.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class UserWithRolesDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

    @JsonProperty("roles")
    private List<RoleDTO> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public static UserWithRolesDTO fromModel(User user){
        UserWithRolesDTO dto = new UserWithRolesDTO();
        dto.setLogin(user.getLogin());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());

        List<RoleDTO> list = new ArrayList<>();
        for(Role role : user.getRoles()){
            list.add(RoleDTO.fromModel(role));
        }

        dto.setRoles(list);
        return dto;
    }
}
