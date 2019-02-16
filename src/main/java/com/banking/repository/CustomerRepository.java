package com.banking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.banking.entity.Customer;

@Repository
public class CustomerRepository  {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Customer customer) {
		entityManager.persist(customer);
	}

	/*public Customer fetch(int id) {
		return entityManager.find(Customer.class, id);
	}*/

	public Customer fetch(long customerId) {
		Query q = entityManager.createQuery("select obj from Customer as obj where obj.id = :id");
		q.setParameter("id", customerId);
	     return (Customer) q.getSingleResult();
	}

	
}
