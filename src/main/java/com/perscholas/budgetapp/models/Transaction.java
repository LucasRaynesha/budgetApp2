package com.perscholas.budgetapp.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="transaction")
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="Name")
    String name;
    @Column(name="Total")
    BigDecimal total;
    @Column(name ="Date")
    String Date;
    @Column(name="Type")
    String type;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Transaction(Integer id, String name, BigDecimal total, String date, String type) {
        this.id = id;
        this.name = name;
        this.total = total;
        Date = date;
        this.type = type;
    }

    public Transaction() {

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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
