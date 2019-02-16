package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Account;
import com.banking.entity.Customer;

public interface LoginRepository extends JpaRepository<Customer, Long> {

 Customer findOneByEmailAndPassword(String email, String password);

	Customer findOneByEmail(String email);

	void save(Account a);



}
