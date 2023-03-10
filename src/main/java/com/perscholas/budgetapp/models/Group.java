package com.perscholas.budgetapp.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="group")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="Name")
    String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
    Set<Category> category = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id")
    private Budget budget;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }


    public Set<Category> getCategory() {
        return category;
    }

    //public void setCategory(Set<Category> category) {
        //this.category = category;
   // }
}
