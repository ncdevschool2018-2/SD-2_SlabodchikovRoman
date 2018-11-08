package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "proffessors", schema = "project", catalog = "")
public class Proffessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Basic
    @Column(name = "name")
    private String name;

    @NotNull
    @Basic
    @Column(name = "surname")

    private String surname;

    @Basic
    @Column(name = "academic_degree")
    @NotNull
    private String academicDegree;

    @NotNull
    @Basic
    @Column(name = "adress")
    private String adress;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proffessor that = (Proffessor) o;
        return id == that.id &&
                Objects.equals(user,that.user) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(academicDegree, that.academicDegree) &&
                Objects.equals(adress, that.adress);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, academicDegree, adress, user);
    }
}
