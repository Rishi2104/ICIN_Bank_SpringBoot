package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RequestRepo extends JpaRepository<Request, String> {


	@Query("select email from Request Request where Request.email=?1")
	String check1(String em);
	
	   
}