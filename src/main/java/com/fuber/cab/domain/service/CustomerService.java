package com.fuber.cab.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.cab.domain.model.Customer;
import com.fuber.cab.domain.repository.CusotmerRepository;
@Service
public class CustomerService {
	@Autowired
	CusotmerRepository cusotmerRepository;
	
	@Transactional
	public Customer create(Customer customer)
	{
		cusotmerRepository.save(customer);
		return customer;
	}
	
	public List<Customer> findAll(Customer customer)
	{
		
		return cusotmerRepository.search(customer);
	}

	public Customer findById(Long id) {
		return cusotmerRepository.findById(id);
		
	}
	
}
