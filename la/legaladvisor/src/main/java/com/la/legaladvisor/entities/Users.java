package com.la.legaladvisor.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.la.legaladvisor.convertors.LocalDateTimeAttributeConverter;
import com.la.legaladvisor.convertors.LocalDateTimeSerializer;

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
    String password;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private  LocalDateTime lastConnected;

    public Users(Long id, String name, String lastName, String password, LocalDateTime lastConnected) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.lastConnected = lastConnected;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastConnected() {
        return lastConnected;
    }

    public void setLastConnected(LocalDateTime lastConnected) {
        this.lastConnected = lastConnected;
    }
}
