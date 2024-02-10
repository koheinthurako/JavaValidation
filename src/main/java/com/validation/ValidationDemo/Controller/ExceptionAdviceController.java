package com.validation.ValidationDemo.Controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.validation.ValidationDemo.exception.NoMatchAmountException;
import com.validation.ValidationDemo.exception.NotFoundSavAccIdException;

@RestControllerAdvice
// 	controller ဘက်ကနေ throw လာတဲ့ error တွေကို ဘယ်သူနဲ့ချိတ်ပြီးအလုပ်လုပ်မယ်ဆိုတာကို ဒီ class ကလုပ်ပေးနိုင်တယ်
//	အသေးစိတ်ဆိုရင် runtime error တက်တဲ့အခါ အောက်က @ExceptionHandler(ထဲမှာခေါ်ထားတဲ့ class) မှာ တက်တဲ့ error တွေကို
//	ဒီ class ကစုထားပေးနိုင်တယ် ဒါကြောင့် 
public class ExceptionAdviceController {
	
	@ExceptionHandler(NotFoundSavAccIdException.class)
//	@ExceptionHandler ကို customize exception တွေနဲ့တွဲသုံးနိုင်တယ် အောက်က method က controller getById()
//	ကနေ error တက်ပြီး throw လာတဲ့ server ရဲ့ default message တွေကို ဒီ class ရဲ့ အောက်က method ကနေစိတ်ကြိုက်ပြင်ပြီးပြခိုင်းနိုင်တယ် 
	public ResponseEntity<Object> noFoundSavAccId(NotFoundSavAccIdException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("time", LocalDateTime.now());
		body.put("message", "not found matching saving account_id");
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoMatchAmountException.class)
	public ResponseEntity<Object> noFoundSavAccId(NoMatchAmountException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("time", LocalDateTime.now());
		body.put("message", "your amount have to be more than 10000");
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}
	
//	public void noFoundSavAccId() {
//	}

}
