package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public class CustomerDAO {

	private EntityManager entityManager;

	@Autowired
	public CustomerDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public List<Customer> findAll() {
		Query theQuery = entityManager.createQuery("from Customer");
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	public Customer findById(int theId) {
		Customer theCustomer = entityManager.find(Customer.class, theId);
		return theCustomer;
	}

	public void save(Customer theCustomer) {
		Customer dbCustomer = entityManager.merge(theCustomer);
		theCustomer.setId(dbCustomer.getId());
	}

	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

}
