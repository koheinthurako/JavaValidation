package com.validation.ValidationDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.validation.ValidationDemo.ServiceImpl.SavingAccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SavingAccTest {
	
//	Start Testing
	
	@Mock
//	Mock က Bean ပဲ bean ကတော့ server ဘက်မှာ object တွေသွားဆောက်ပေမယ့် Mock ကတော့ server ဘက်မှာ object မဆောက်ပေးဘူး
	SavingAccountServiceImpl service;

//	Testing ကို method နာမည်ပေးတဲ့အခါ တစ်ခါတည်းနားလွယ်လွယ်အောင် ပေးလေ့ရှိတယ် (method နာမည်_အလုပ်လုပ်စေချင်တဲ့ function, return ပုံစံ)
	@Test
	@DisplayName("test Saving Acc with Deposit")
	public void callDeposit_withdrawAmount_willReturnIncreaseAmount() {
		int new_amount = service.deposit(20);
//		assert keyword ကို testing ပိုင်းမှာအသုံးများတယ်
		assertEquals(10020, new_amount);
	}
	
	
	

}
