package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "subjects", schema = "project", catalog = "")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "name")
    private String name;


    @Basic
    @NotNull
    @Column(name = "cathedra")
    private String cathedra;


    @ManyToOne
    @NotNull
    @JoinColumn(name = "proff_id", nullable = false)
    private Proffessor proffessor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Proffessor getProffessor() {
        return proffessor;
    }

    public void setProffessor(Proffessor proffessor) {
        this.proffessor = proffessor;
    }

    public String getCathedra() {
        return cathedra;
    }

    public void setCathedra(String cathedra) {
        this.cathedra = cathedra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject that = (Subject) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(proffessor, that.proffessor) &&
                Objects.equals(cathedra, that.cathedra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, proffessor, cathedra);
    }
}
