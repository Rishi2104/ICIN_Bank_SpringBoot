package com.example.demo;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ResponseBody
@CrossOrigin("*")
@RequestMapping("/Controller")
public class AdminController {
@Autowired
	Admindao dao;
Logger log=Logger.getAnonymousLogger();
@PostMapping("/login")
public Admin login_data(@RequestBody Admin user) throws Exception {
	log.info("Data Received-------> "+user+"\n email-> "+user.getEmail());
	String em=user.getEmail();
	String psw=user.getPassword();
	log.info("inside the request mapping of login");
	//log.info("object from user: "+user.getEmail());
	Admin kk=dao.findbyuser(em);
	log.info("object from return repo: "+kk);
	if(dao.findbyuser(em)==null)
	{
		log.info("-------NULL value CAUGHT....");
		return null;
	}
	else if(psw.equals(kk.getPassword())) {
		log.info("validation of the user is successfull");
			log.info("created log-in object _>"+user);	
			return kk;
			
	}
	else {
		log.info("User Id = "+em+" Password = "+dao.findbypassword(em));
		log.info("failed");
		return kk;
	}
	
}



@PostMapping("/register")
@ResponseBody
public Admin Admin_data(@RequestBody Admin user) throws Exception {
	log.info("Data Received-------> "+user+"\n email-> "+user.getEmail());
	String em=user.getEmail();
	String psw=user.getPassword();
	String ph=user.getPhone();
	String name=user.getName();
	log.info("inside the request mapping of register");
	log.info("object from user: "+user.getEmail()+psw+ph+name);
	//log.info("object from return repo: "+dao.findbyuser(em));
	if(dao.findbyuser(em)==null)
	{
		if(user.getType()==null) {
			user.setType("user");
		}
		Admin ss=dao.insert(user);
		log.info("-------NULL! Can be insterted...."+ss);
		if(ss!=null)
		return user;
	}
	else if(dao.findbyuser(user.getEmail()).equals(dao.findbypassword(user.getPassword()))) {
		log.info("validation of the user is successfull");
			log.info("created loggedin object");			
			return user;
	}
	else {
		log.info("failed");
		return user;
	}
	return null;
	
}


@CrossOrigin("*")
@PostMapping("/transaction/")
public Transaction transaction_data(@RequestBody Transaction user) throws Exception {
	log.info("Data Received-------> "+user+"\n email-> "+user.getEmail());
	String em=user.getEmail();
	int total2=0,total1 = 0;
	log.info("inside the request mapping of login"+em);
	
	//log.info("object from return repo: "+dao.findbyuser(em));
	if(em!=null && dao.findNull(em)!=null) {
	total1=Integer.parseInt(dao.findTotal(em));
	user.setTotal(total1);
	
	total2=(int) dao.findTotal2(em);
	user.setCurrent(total2);
	
	log.info("object from user: "+total1+" _>>"+total2);
	return user;
	}
	else {
		user.total=total1;
		user.current=total2;
		return user;
	}
	
}


@PostMapping("/profile/")
public Admin profile_data(@RequestBody Admin user) throws Exception {
	log.info("Data Received------->/profile--> "+user+"\n email-> "+user.getEmail());
	String em=user.getEmail();
	log.info("inside the request mapping of login"+em);
	List<Admin> ss=dao.profile(em);
	log.info("ss -> "+ss.get(0));
	return ss.get(0);
}
	
	
	@PostMapping("/request/")
	public Request requestC(@RequestBody Request user) throws Exception {
		log.info("Data Received------->/request--> "+user+"\n email-> "+user.getEmail());
		String em=user.getEmail();
		String e="AlreadyExists";
		log.info("inside the request mapping of login"+em);
		String x=dao.check(em);
		log.info("String X= "+x);
		if(x==null)
		{
			log.info("inside X==null, email= "+em);
			Request ss=dao.request1(user);
			 return ss;
			
			
		}
		else {
			log.info("inside the if(x)"+em+" e="+e);
			user.setEmail(e);
			return user;
			 
		}
		
	}


@PostMapping("/deposit/")
public Transfer depositData(@RequestBody Transfer user) throws Exception {
	log.info("Data Received------->/deposit--> "+user+"\n email-> "+user.getEmail());
	String em=user.getEmail();
	int t=dao.Tid_Count();
	log.info("Data Received------->/t--> "+t);
	user.setTid(t+1);
	log.info("inside the request mapping of login-> "+em+user.getDeposit());
	Transfer ss=dao.deposit(user);
	return ss;
	
}


@PostMapping("/withdraw/")
public Transfer withdrawData(@RequestBody Transfer user) throws Exception {
	log.info("Data Received------->/deposit--> "+user+"\n email-> "+user.getEmail());
	String em=user.getEmail();
	int t=dao.Tid_Count();
	log.info("Data Received------->/t--> "+t);
	user.setTid(t+1);
	log.info("inside the request mapping of login-> "+em+user.getWithdraw());
	Transfer ss=dao.withdraw(user);
	return ss;
	
}

@PostMapping("/ad-request/")
public List<Request> ADrequest( @RequestBody Request user) {
	// TODO Auto-generated method stub
	return dao.Arequest();
}
		
	

}




