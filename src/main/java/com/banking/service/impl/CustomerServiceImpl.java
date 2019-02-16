package com.banking.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.dto.LoginDto;
import com.banking.dto.LoginStatus;
import com.banking.dto.RegisterDto;
import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.repository.AccountRepository;
import com.banking.repository.CustomerRepository;
import com.banking.repository.LoginRepository;
import com.banking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public LoginStatus login(LoginDto loginDto) {
		LoginStatus status = new LoginStatus();
		
		Customer customer = loginRepository.findOneByEmail(loginDto.getEmail());
		if(!customer.isNotLocked()) {
			if(!customer.getPassword().equals(loginDto.getPassword()))
					status.setStatus("Password Mismatch");
			else {
				status.setStatus("Successful!");
				status.setName(customer.getFirstName() + " " + customer.getLastName());
				status.setCustomerId(customer.getId());
			}
				
		}
		else {
			status.setStatus("Account Locked");
		}
		return status;
	}

	@Transactional 
	public void register(RegisterDto registerDto) {
		Customer c = new Customer();
		c.setFirstName(registerDto.getFirstName());
		c.setLastName(registerDto.getLastName());
		c.setEmail(registerDto.getEmail());
		c.setMiddleName(registerDto.getMiddleName());
	     c.setMobileNo(registerDto.getMobileNo());
		c.setTitle(registerDto.getTitle());
		c.setPassword(registerDto.getPassword());
	
		
		Account a = new Account();
		a.setAccountType(registerDto.getAccountType());
		a.setBalance(registerDto.getBalance());
		a.setCustomer(c);
		c.setAccount(a);
		
		customerRepository.save(c);
		
	}
	public List<Customer> fetchAll(){
		return null;
	}

	
		
}
