package com.fuber.cab.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fuber.cab.domain.model.Customer;
import com.fuber.cab.domain.service.CustomerService;
import com.fuber.cab.web.view.CustomerResult;
import com.fuber.cab.web.view.Result;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer/create",method=RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })
    public Result create(@RequestBody Customer customer,BindingResult error )
    {
		Result result=new Result();
		if(error.hasErrors())
		{
			System.out.println(error);
			result.setStatus("Failure");
			result.setError("Failed to add Customer");
			result.setErorMessage(error.toString());
			
		}
		customerService.create(customer);
		result.setStatus("Success");
		result.setMessage("Customer "+customer.getName()+" Added Successfully");
		return result;
		
    }
	
	@RequestMapping(value="/customer/search",method=RequestMethod.POST, consumes = { "application/json" },produces = { "application/json" })
    public CustomerResult search(@RequestBody Customer customer,BindingResult error )
    {
		CustomerResult result=new CustomerResult();
		if(error.hasErrors())
		{
			System.out.println(error);
			result.setStatus("Failure");
			result.setError("Failed to add Customer");
			result.setErorMessage(error.toString());
			
		}
		
		result.setCustomers(customerService.findAll(customer));
		result.setStatus("Success");
		return result;
		
    }
	
	@RequestMapping(value="/customer/view/{id}",method=RequestMethod.GET, consumes = { "application/json" },produces = { "application/json" })
    public CustomerResult search(@PathVariable Long id )
    {
		CustomerResult result=new CustomerResult();
		
		
		Customer customerById = customerService.findById(id);
		List<Customer> customers=new ArrayList<Customer>();
		customers.add(customerById);
		result.setCustomers(customers);
		result.setStatus("Success");
		return result;
		
    }
	
	
	
}
