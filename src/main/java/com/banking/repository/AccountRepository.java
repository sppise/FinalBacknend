package com.banking.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.banking.entity.Account;

@Repository
public class AccountRepository {
 
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Account account) {
		entityManager.persist(account);
	}

	public Account findById(long acno) {
		return entityManager.find(Account.class, acno);
	}
	
	
}
