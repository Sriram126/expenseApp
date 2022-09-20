package com.springExpenseApp.expenseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springExpenseApp.expenseApp.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
