package com.validation.ValidationDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validation.ValidationDemo.Entities.SavingAccount;

public interface SavingAccountRepo extends JpaRepository<SavingAccount, Integer>{
	
	

}
