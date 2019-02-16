package com.banking.service;

import java.util.List;

import com.banking.dto.LoginDto;
import com.banking.dto.LoginStatus;
import com.banking.dto.RegisterDto;
import com.banking.entity.Customer;

public interface CustomerService {
	
	public LoginStatus login(LoginDto loginDto);
   public void register(RegisterDto registerDto);


}
