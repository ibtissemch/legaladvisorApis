package com.la.legaladvisor.tdos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


public class UsersDto implements Serializable {

    private static final long serialVersionUID=1L;
    Long id;
    String name;
    String lastName;
    String password;
    LocalDateTime LastConnected;

    public UsersDto(Long id, String name, String lastName, String passWord, LocalDateTime lastConnected) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        password = passWord;
        LastConnected = lastConnected;
    }

    public UsersDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastConnected() {
        return LastConnected;
    }

    public void setLastConnected(LocalDateTime lastConnected) {
        LastConnected = lastConnected;
    }
}
