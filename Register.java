package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Register {
	@Id
	private String email;
	private String password;
	private String phone;
	private String name;
	
	
}