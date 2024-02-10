package com.validation.ValidationDemo.exception;

public class NotFoundSavAccIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundSavAccIdException() {
		super("Not found match ID");
//		ဒီလို့ရေးလိုက်ရင် server ဘက်မှာ error က အများကြီးပေါ်လာပြီး အပေါ်က MSG ကိုထုတ်ပေးနိုင်တယ် သို့သော် ကိုယ့်စိတ်ကြိုက် MSG ကိုထုတ်ပေးမယ်ဆိုရင်
//		ExceptionAdviceController ကိုသွားကြည့်
	}
	
}
