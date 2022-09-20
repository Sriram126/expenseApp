package com.springExpenseApp.expenseApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springExpenseApp.expenseApp.model.Expense;
import com.springExpenseApp.expenseApp.service.ExpenseService;

@CrossOrigin("*")
@RestController
public class ExpenseController {
 
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expense")
	public ResponseEntity<List<Expense>> get(){
		List<Expense> expenses = expenseService.findAll();
		return new ResponseEntity<List<Expense>>(expenses,HttpStatus.OK);
	}
	
}
