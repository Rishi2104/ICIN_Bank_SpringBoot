package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Transfer {
	@Id
	private int tid;
	private String email;
	private String withdraw;
	private String deposit;
	
	
	
}