package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

	@Query("select Transaction.total from Transaction Transaction where Transaction.email=?1")
	String findTotalAmount(String em);
	
	@Query("select email from Transaction Transaction where Transaction.email=?1")
	String FindNull(String em);
	@Query("select current from Transaction Transaction where Transaction.email=?1")
	int findCurrentAmount(String em);
	
	@Transactional
	@Modifying
	@Query("update Transaction Transaction set Transaction.total=?1 where Transaction.email=?2")
	void updateTotal(int x1, String em);

	
// String updateTotal(int x2,String em);	
//	Logger log=Logger.getAnonymousLogger();
//	@Query("select Transaction from Transaction Transaction where Admin.email=?1 AND Ac.type=?2")
//	public Admin findByuser(String email,String type);
//	
//	@Query("select Admin from Admin Admin where Admin.password=?1")
//	public Admin findBypassword(String password);
//	
}