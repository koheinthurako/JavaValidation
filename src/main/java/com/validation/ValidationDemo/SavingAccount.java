package com.validation.ValidationDemo;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class SavingAccount {

	private int a_id;
	
	@NotBlank(message = "*** Have to fill ***")
	private String name;
	
	@NotBlank(message = "*** Have to fill ***")
	@Email(message = "*** Email format wrong ***")
	private String email;
	private LocalDate dob;
	@Length(max = 11, message = "*** Phone number wrong ***")
	private String pno;
	@Min(value = 10000, message = "*** Not enough amount ***")
	private int amount;
	
}
