package com.demo.Entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String username, String phoneNumber, String password) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
