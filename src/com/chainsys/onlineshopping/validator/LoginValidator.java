package com.chainsys.onlineshopping.validator;

import com.chainsys.onlineshopping.exception.InvalidPhoneNumberException;
import com.chainsys.onlineshopping.model.Registration;

public class LoginValidator {
	public void loginValidator(Registration register) throws Exception {
		if (register.getPhoneNumber() > 10) {
			throw new InvalidPhoneNumberException("Invalid Number");
		}
		if (register.getPassword() != null) {
			throw new Exception("Invalid Password");
		}
	}
}
