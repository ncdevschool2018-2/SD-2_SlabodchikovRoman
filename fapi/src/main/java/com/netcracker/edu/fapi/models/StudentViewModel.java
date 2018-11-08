package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentViewModel {
    private long id;
    private String faculty;
    private String name;
    private String surname;
    private String adress;
    private GroupViewModel group;
    private UserViewModel user;

    public StudentViewModel() {
    }

    public StudentViewModel(long id, String faculty, String name, String surname, String adress, GroupViewModel group, UserViewModel user) {
        this.id = id;
        this.faculty = faculty;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.group = group;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public GroupViewModel getGroup() {
        return group;
    }

    public void setGroup(GroupViewModel group) {
        this.group = group;
    }

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }
}
