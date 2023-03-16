package com.rayneshalucas.budgetapp.service;

import com.rayneshalucas.budgetapp.dao.TransactionRepository;
import com.rayneshalucas.budgetapp.models.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = SQLException.class)
public class TransactionService {

    TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public Transaction saveTransaction(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }
    public List<Transaction> getTransactionsForUser(Integer userId) {
        return this.transactionRepository.findByUserId(userId);
    }

    public Optional<Transaction> get(Integer id) {
        return transactionRepository.findById(id);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}