package com.la.legaladvisor.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    String name;
    String lastName;
    String PassWord;
    LocalDateTime LastConnected;

    public Users(Long id, String name, String lastName, String passWord, LocalDateTime lastConnected) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        PassWord = passWord;
        LastConnected = lastConnected;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public LocalDateTime getLastConnected() {
        return LastConnected;
    }

    public void setLastConnected(LocalDateTime lastConnected) {
        LastConnected = lastConnected;
    }
}
