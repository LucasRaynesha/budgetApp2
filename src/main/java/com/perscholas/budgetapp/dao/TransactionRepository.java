package com.perscholas.budgetapp.dao;

import com.perscholas.budgetapp.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findByName (String name);
    Optional<Transaction> findByTotal (BigDecimal total);

    Optional<Transaction> findByDate (String Date);

    Optional<Transaction> findByType (String type);
}