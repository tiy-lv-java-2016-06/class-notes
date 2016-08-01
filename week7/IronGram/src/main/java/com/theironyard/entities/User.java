package com.theironyard.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by jeff on 7/28/16.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

//    @OneToMany(mappedBy = "recipient")
//    private Collection<Photo> waitingPhotos;

//    @Column(nullable = false, columnDefinition = "varchar(255) DEFAULT 'test@test.com'")
//    @Size(min = 6)
//    private String email;
//
//    @Column(nullable = false, columnDefinition = "varchar(255) DEFAULT 'las vegas'")
//    private String city;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }

//    public User(String name, String password, String email, String city) {
//        this.name = name;
//        this.password = password;
//        this.email = email;
//        this.city = city;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
}
