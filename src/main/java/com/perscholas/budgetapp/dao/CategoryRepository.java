package com.perscholas.budgetapp.dao;

import com.perscholas.budgetapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName (String name);
    Optional<Category> findByAmount (BigDecimal Amount);

}