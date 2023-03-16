package com.rayneshalucas.budgetapp.service;

import com.rayneshalucas.budgetapp.dao.*;
import com.rayneshalucas.budgetapp.models.Budget;
import com.rayneshalucas.budgetapp.models.MyUser;
import com.rayneshalucas.budgetapp.models.Transaction;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@Slf4j

public class MyCommandLineRunner implements CommandLineRunner {
    // The instance of bringing the repo in
    // It grabs it from the beans created @autowired tells it what object is available
    MyUserRepository userRepo;
    BudgetRepository budgetRepo;
    TransactionRepository transactionRepo;

    @Autowired
    public MyCommandLineRunner(MyUserRepository userRepo, BudgetRepository budgetRepo, TransactionRepository transactionRepo) {
        this.userRepo = userRepo;
        this.budgetRepo = budgetRepo;
        this.transactionRepo = transactionRepo;
    }
    @PostConstruct
    void created(){
        log.warn(" -------------Command Line Runner has been created!!!!!! ------------- ");

    }

    @Override
    public void run(String... args) throws Exception {
        // creating the instance of a new user
        MyUser user1 = new MyUser("Raynesha","Lucas","Username@gmail.com", "password");
        MyUser user2 = new MyUser("Karen","Jones","Userlover@gmail.com", "password1");
        MyUser user3 = new MyUser("Larry", "Zeus","happydays@gmail.com", "password2");
        MyUser user4 = new MyUser("Buddy", "Club","kevingates@gmail.com", "password3");
        MyUser user5 = new MyUser("Zoo", "Loo", "rickymartin@gmail.com", "password4");
        MyUser user6 = new MyUser("Adam", "Eve", "aa@aa.com", "pp");

        user1 =userRepo.save(user1);
        user2 =userRepo.save(user2);
        user3 =userRepo.save(user3);
        user4 =userRepo.save(user4);
        user5 =userRepo.save(user5);
        user6 =userRepo.save(user6);
        log.warn(user1.toString());


        Budget budget = new Budget("food");
        Budget budget2 = new Budget("house");
        Budget budget3 = new Budget("car");
        Budget budget4 = new Budget("entertainment");
        Budget budget5 = new Budget("health");

        budget=budgetRepo.save(budget);
        budget2=budgetRepo.save(budget2);
        budget3=budgetRepo.save(budget3);
        budget4=budgetRepo.save(budget4);

        budget.setUserId(user3.getId());
        budget=budgetRepo.save(budget);
        log.warn(budget.toString());

        Date date1 = new Date(LocalDate.parse("2023-03-10").toEpochDay());
        Date date2 = new Date(LocalDate.parse("2023-03-13").toEpochDay());
        Date date3 = new Date(LocalDate.parse("2023-03-14").toEpochDay());
        Transaction transaction = new Transaction("Kroger", 89.23, date1, "Dinner", "food");
        Transaction transaction1 = new Transaction("Target", 103.09, date2, "Hall fix","decorations");
        Transaction transaction2 = new Transaction("Lowes", 1004.0, date3, "Wall Fix", "house");

        transactionRepo.save(transaction);
        transactionRepo.save(transaction1);
        transactionRepo.save(transaction2);
    }
}
