package com.example.demo;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface Adminrepo extends JpaRepository<Admin, String> {
	Logger log=Logger.getAnonymousLogger();
	@Query("select Admin from Admin Admin where Admin.email=?1")
	public Admin findByuser(String email);
	
	@Query("select Admin from Admin Admin where Admin.email=?1")
	public Admin findBypassword(String em);
	
	
	@Query(value="select email,name,password,phone,type from Admin Admin where Admin.email=?1",nativeQuery=true)
	List<Admin>  profile1(String em);

	
}