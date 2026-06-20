package com.piotr.flightsearchapi.domain.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "flightsearch")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Email;
    private String PasswordHash;

    public User() {
    }

    public User(Integer id, String email, String passwordHash) {
        Id = id;
        Email = email;
        PasswordHash = passwordHash;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", PasswordHash='" + PasswordHash + '\'' +
                '}';
    }
}
