package com.springExpenseApp.expenseApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/expenses")
	public ResponseEntity<Expense> save(@RequestBody Expense expense) {
		Expense expenseOne = expenseService.save(expense);
		return new ResponseEntity<Expense>(expenseOne, HttpStatus.OK);
	}
	
	@GetMapping("/expenses/{id}")
	public ResponseEntity<Expense> get(@PathVariable("id") Long id) {
		Expense expense = expenseService.findById(id);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		expenseService.delete(id);
		return new ResponseEntity<String>("Expense is deleted successfully.!", HttpStatus.OK);
	}
	
}
