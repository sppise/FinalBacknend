package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.banking.dto.LoginDto;
import com.banking.dto.LoginStatus;
import com.banking.dto.RegisterDto;
import com.banking.entity.Customer;
import com.banking.repository.CustomerRepository;
import com.banking.repository.LoginRepository;
import com.banking.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

    @PostMapping("/register")
	public void register(@RequestBody RegisterDto registerDto) {
		customerService.register(registerDto);
	}

	@PostMapping("/login")
	public LoginStatus login(@RequestBody LoginDto loginDto) {
		LoginStatus loginStatus = customerService.login(loginDto);
		return loginStatus;
	}

	@GetMapping("/details/{customerId}")
	public Customer sendData(@PathVariable("customerId") long customerId) {
		return customerRepository.fetch(customerId);
	}
	
}
