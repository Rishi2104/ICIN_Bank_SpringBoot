package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admindao {
	@Autowired
	Adminrepo repo;
	@Autowired
	TransactionRepo repo1;
	@Autowired
	RequestRepo repo2;
	@Autowired
	TranferRepo repo3;
	Logger log=Logger.getAnonymousLogger();
	public Admin findbyuser(String user) {
		log.info("AdminDAO-> findbyuser..."+user);
		return repo.findByuser(user);
	}
	
	
	public Admin findbypassword(String em) {
		log.info("AdminDAO-> findbyPassword...");
		return repo.findBypassword(em);
	}
	
	public Admin insert(Admin user) {
		log.info("AdminDAO-> insert...");
		
		return repo.save(user);
	}


	public String findTotal(String em) {
		// TODO Auto-generated method stub
		return repo1.findTotalAmount(em);
		
	}


	public String findNull(String em) {
		// TODO Auto-generated method stub
		return repo1.FindNull(em);
	}


	public int findTotal2(String em) {
		// TODO Auto-generated method stub
		return (int) repo1.findCurrentAmount(em);
	}


	public List<Admin> profile(String em) {
		// TODO Auto-generated method stub
		return repo.profile1(em);
		
	}


	public Request request1(Request em) {
		// TODO Auto-generated method stub
		return repo2.save(em);
		
		
		
	}


	public String check(String em) {
		log.info("inside check "+em);
		// TODO Auto-generated method stub
		return repo2.check1(em);
		 
	}


	public Transfer deposit(Transfer user) {
		// TODO Auto-generated method stub
		if(repo3.save(user) != null)
		{
			String em=user.getEmail();
			log.info("Data em--> "+em+" Total Amount: "+repo1.findTotalAmount(em));
			int x1= Integer.parseInt(repo1.findTotalAmount(em));
			log.info("inside x1 "+x1);
			x1=x1+(Integer.parseInt(user.getDeposit()));
			String x2= (Integer.toString(x1));
			log.info("After addition x1 abd x2 = "+x1 +" String= "+ x2);
			repo1.updateTotal(x1,em);
			return user;
		}
		return null;
	}

	public Transfer withdraw(Transfer user) {
		// TODO Auto-generated method stub
		if(repo3.save(user) != null)
		{
			String em=user.getEmail();
			log.info("Data em--> "+em+"Total Amount: "+repo1.findTotalAmount(em));
			int x1= Integer.parseInt(repo1.findTotalAmount(em));
			log.info("inside x1 "+x1);
			x1=x1-(Integer.parseInt(user.getWithdraw()));
			String x2= (Integer.toString(x1));
			log.info("After addition x1 abd x2 = "+x1 +" String= "+ x2);
			repo1.updateTotal(x1,em);
			return user;
		}
		return null;
	}


	public int Tid_Count() {
		// TODO Auto-generated method stub
		return (int) repo3.count();
	}


	public List<Request> Arequest() {
		// TODO Auto-generated method stub
		return repo2.findAll();
	}


	
		
	}






