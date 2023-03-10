package com.perscholas.budgetapp.service;

import com.perscholas.budgetapp.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    MyUserRepository userRepo;
    BudgetRepository budgetRepo;
    GroupRepository groupRepo;
    TransactionRepository transactionRepo;
    CategoryRepository categoryRepo;

    @Autowired
    public MyCommandLineRunner(MyUserRepository userRepo, BudgetRepository budgetRepo, GroupRepository groupRepo, TransactionRepository transactionRepo, CategoryRepository categoryRepo) {
        this.userRepo = userRepo;
        this.budgetRepo = budgetRepo;
        this.groupRepo = groupRepo;
        this.transactionRepo = transactionRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
