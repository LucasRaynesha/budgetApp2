package com.perscholas.budgetapp.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name ="categories")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name ="Name")
    String name;
    @Column(name ="Amount")
    BigDecimal amount;
    @Column(name ="Start")
    String begDate;
    @Column(name ="End")
    String endDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

    //Set<Transaction> transaction = new TreeSet<>();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Category(Integer id, String name, BigDecimal amount, String begDate, String endDate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.begDate = begDate;
        this.endDate = endDate;
    }

    public Category() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }


}
