package com.validation.ValidationDemo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.validation.ValidationDemo.Entities.SavingAccount;
import com.validation.ValidationDemo.Repo.SavingAccountRepo;
import com.validation.ValidationDemo.Service.SavingAccountService;

@Configuration
public class SavingAccountServiceImpl implements SavingAccountService {
	
	@Autowired
	SavingAccountRepo accRepo;
	
	@Override
	public List<SavingAccount> getAll() {
		return accRepo.findAll();
	}

	@Override
	public SavingAccount save(SavingAccount acc) {
		return accRepo.save(acc);
	}
	
	
}
