package com.FinalProject.BookStore.data.entity;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin extends User{

    @Column
    private String name;

    public Admin() {}

    public Admin(Integer userId, String username, String password, Integer type, String name) {
        super(userId, username, password, type);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
