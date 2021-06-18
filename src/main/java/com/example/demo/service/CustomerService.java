package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;

@Service
public class CustomerService {

	private CustomerDAO customerDAO;

	@Autowired
	public CustomerService(@Qualifier("customerDAO") CustomerDAO theCustomerDAO) {
		customerDAO = theCustomerDAO;
	}

	@Transactional
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}
}
