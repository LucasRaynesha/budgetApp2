package com.perscholas.budgetapp.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.TreeSet;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="user")
public
class MyUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "User")
    String userName;

    String password;



    @OneToMany
    Set<Budget> budget = new TreeSet<>();


    public MyUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public MyUser() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY , mappedBy = "user")
    public Set<Budget> getBudget() {
        return budget;
    }

    public void setBudget(Set<Budget> budget) {
        this.budget = budget;
    }


}
