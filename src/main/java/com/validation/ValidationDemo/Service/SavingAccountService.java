package com.validation.ValidationDemo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.validation.ValidationDemo.Entities.SavingAccount;

@Service
public interface SavingAccountService {
	
	public List<SavingAccount> getAll();
	public SavingAccount save(SavingAccount acc);

}
