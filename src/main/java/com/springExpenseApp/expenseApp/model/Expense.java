package com.springExpenseApp.expenseApp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_expense")
@Getter
@Setter

public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String expense;
	
	private String description;
	
	private BigDecimal amount;

	public Expense(long id, String expense, String description, BigDecimal amount) {
		super();
		this.id = id;
		this.expense = expense;
		this.description = description;
		this.amount = amount;
	}

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
