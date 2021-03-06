package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserViewModel {
    private long id;
    private String login;
    private String password;
    private RoleViewModel role;

    public UserViewModel(long id, String login, String password, RoleViewModel role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserViewModel() {
    }

    public RoleViewModel getRole() {
        return role;
    }

    public void setRole(RoleViewModel role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
