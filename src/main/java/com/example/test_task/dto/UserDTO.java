package com.example.test_task.dto;

import com.example.test_task.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

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

    public static UserDTO fromModel(User user){
        UserDTO dto = new UserDTO();
        dto.setLogin(user.getLogin());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
