package com.example.manvi.restfulwebservices.User;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

//@JsonFilter("userFilter") // required for dynamic filtering
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @Past
    private Date birthDate;

    protected User() {

    }

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }

}
