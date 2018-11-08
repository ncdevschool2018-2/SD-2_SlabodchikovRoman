package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectViewModel {
    long id;
    String name;
    String cathedra;
    ProffessorViewModel proffessor;

    public SubjectViewModel() {
    }

    public SubjectViewModel(long id, String name, String cathedra, ProffessorViewModel proffessor) {
        this.id = id;
        this.name = name;
        this.cathedra = cathedra;
        this.proffessor = proffessor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCathedra() {
        return cathedra;
    }

    public void setCathedra(String cathedra) {
        this.cathedra = cathedra;
    }

    public ProffessorViewModel getProffessor() {
        return proffessor;
    }

    public void setProffessor(ProffessorViewModel proffessor) {
        this.proffessor = proffessor;
    }
}
