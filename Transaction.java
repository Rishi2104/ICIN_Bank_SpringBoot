package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Transaction {
	@Id
	private String tid;
	private String email;
	public int total;
	public int current;
	
	
}