package com.perscholas.budgetapp.dao;

import com.perscholas.budgetapp.models.Budget;
import com.perscholas.budgetapp.models.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class BudgetRepositoryTest {

    @Autowired
    private BudgetRepository underTest;

    @Test
    public void


    @Test
    void itShouldfindById() {
    }

    @Test
    void itShouldfindByUserId() {
    }
}