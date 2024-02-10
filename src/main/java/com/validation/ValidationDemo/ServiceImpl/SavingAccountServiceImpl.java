package com.validation.ValidationDemo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.validation.ValidationDemo.Entities.SavingAccount;
import com.validation.ValidationDemo.Repo.SavingAccountRepo;
import com.validation.ValidationDemo.Service.SavingAccountService;
import com.validation.ValidationDemo.exception.NoMatchAmountException;
import com.validation.ValidationDemo.exception.NotFoundSavAccIdException;

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

	@Override
	public SavingAccount getById(int id) {
//		orElseThrow() က id မတွေ့လို့ runtime error တစ်ခုတွေ့ခဲ့ရင် console မှာဖြစ်ဖြစ်တစ်ခုခုလုပ်ချင်ရင်သုံးတယ်
		return accRepo.findById(id).orElseThrow(() -> new NotFoundSavAccIdException());
	}

	@Override
	public String withdraw(int amount) {
		if(amount < 10000) {
			throw new NoMatchAmountException(); // customize exception
		} else {
			return "You can withdraw.";
		}
		
	}
	
	
}
