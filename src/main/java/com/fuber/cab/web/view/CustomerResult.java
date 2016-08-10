package com.fuber.cab.web.view;

import java.util.List;

import com.fuber.cab.domain.model.Customer;

public class CustomerResult extends Result{
	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	 

}
