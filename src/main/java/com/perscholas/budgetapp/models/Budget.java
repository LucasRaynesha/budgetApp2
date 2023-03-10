package com.perscholas.budgetapp.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.TreeSet;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="budget")
public class Budget {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="Name")
    String name;
    @ManyToOne
    @JoinColumn(name = "User Id")
    MyUser user;

    Set<Group> group = new TreeSet<>();

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }


    public Budget(Integer id, String name, MyUser user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Budget() {

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "budget")
    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }


}
