package com.springExpenseApp.expenseApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springExpenseApp.expenseApp.model.Expense;
import com.springExpenseApp.expenseApp.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	public List<Expense> findAll() {
		
		return expenseRepository.findAll();
	}
	
	public Expense save(Expense expense) {
		expenseRepository.save(expense);
		return expense;
	}

	public Expense findById(Long id) {
		if(expenseRepository.findById(id).isPresent()){
			return expenseRepository.findById(id).get();
		}
		return null;
	}

	public void delete(Long id) {
		Expense expense = findById(id);
		expenseRepository.delete(expense);
	}
  
}
