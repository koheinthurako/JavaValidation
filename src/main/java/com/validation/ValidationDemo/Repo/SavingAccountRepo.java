package com.validation.ValidationDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.validation.ValidationDemo.Entities.SavingAccount;

@Repository
@EnableJpaRepositories
public interface SavingAccountRepo extends JpaRepository<SavingAccount, Integer>{
	
	

}
