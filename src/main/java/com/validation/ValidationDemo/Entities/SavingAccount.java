package com.validation.ValidationDemo.Entities;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SavingAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int a_id;
	
//	Start checking validation by adding annotation
	
	@NotBlank(message = "*** Have to fill ***")
//	blank မဖြစ်ရ message ဆိုတာ error တက်ခဲ့ရင်ပြချင်တဲ့ message
	private String name;
	
	@NotBlank(message = "*** Have to fill ***")
	@Email(message = "*** Email format wrong ***")
//	Email လို့ရေးရင် Email format နဲ့ကိုက်မကိုက် auto စစ်ပေးနိုင်တယ်
	private String email;
	
	private LocalDate dob;
	
	@Length(max = 11, message = "*** Phone number wrong ***")
	private String pno;
	
	@Min(value = 10000, message = "*** Not enough amount ***")
//	MIN အနည်းဆုံး value = 10000 ရှိမှရမယ်ဆိုတဲ့ သဘော
	private int amount;
	
}
