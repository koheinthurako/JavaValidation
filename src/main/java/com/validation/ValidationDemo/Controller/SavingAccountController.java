package com.validation.ValidationDemo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.ValidationDemo.Entities.SavingAccount;
import com.validation.ValidationDemo.Service.SavingAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("acc")
public class SavingAccountController {

	@Autowired
	SavingAccountService service;

//	@PostMapping("/save")
//	public ResponseEntity<String> save(@Valid @RequestBody SavingAccount acc, BindingResult) {
//		List<ObjectError> errors = result.getAllErrors();
//		if(errors.size() == 0) {
//			service.save(acc);
//			return new ResponseEntity<String>("saved", HttpStatus.ACCEPTED);
//		} else {
//			String s = errors.stream().map(error->error.getDefaultMessage()).collect(Collec)
//		}
//	}

	@GetMapping("/get")
	public ResponseEntity<List<SavingAccount>> getAll() {
		return new ResponseEntity<List<SavingAccount>>(service.getAll(), HttpStatus.OK);
	}

	@PostMapping("/save")
//	Valid က DB ထဲကို validation စစ်ပြီးထည့်တာမို့ error တက်မတက် ဖမ်းပေးနိုင်တယ်
//	BindingResult ကတော့ valid က ဖမ်းလိုက်လို့ တက်တဲ့ error တွေကို console မှာထုတ်ပြတာတို့ကို လုပ်ပေးနိုင်တယ်

	public ResponseEntity<String> save(@Valid @RequestBody SavingAccount acc, BindingResult result) {
//		result.getAllErrors() return က ObjectError
		List<ObjectError> errors = result.getAllErrors();
		if (errors.size() == 0) {
//			errors.size() == 0 က error မရှိဘူးဆိုမှ database ထဲကိုဝင် အလုပ်လုပ်ခိုင်းတာဖြစ်တယ်
			service.save(acc);
//			return new ResponseEntity<SavingAccount>(service.save(acc), HttpStatus.ACCEPTED);
			return new ResponseEntity<String>("saved", HttpStatus.ACCEPTED);
		} else {
			String err_st = "";
//			for(ObjectError err : errors) {
//				err_st += err.getDefaultMessage()+System.lineSeparator();
//			}

//			err_st = errors.stream().map(err -> err.getDefaultMessage()).collect(Collectors.joining("," + System.lineSeparator()));
			err_st = errors.stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining("," + System.lineSeparator()));
			return new ResponseEntity<String>(err_st, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<SavingAccount> get(@PathVariable int id) {
		return new ResponseEntity<SavingAccount>(service.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/withdraw/{amt}")
	public ResponseEntity<String> withdraw(@PathVariable int amt) {
		return new ResponseEntity<String>(service.withdraw(amt), HttpStatus.OK);
	}
	

}
