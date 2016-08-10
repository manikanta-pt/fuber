package com.fuber.cab.domain.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fuber.cab.domain.model.Customer;
@Repository
public class CusotmerRepository {  

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Customer save(Customer customer)
	{
		
		try {
			entityManager.persist(customer);  
			entityManager.flush();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return customer;
	}
	
	
	public List<Customer> search(Customer customer) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> createQuery = cb.createQuery(Customer.class);
		Root<Customer> customers = createQuery.from(Customer.class);
		createQuery.select(customers);
		Metamodel m = entityManager.getMetamodel();
		EntityType<Customer> Customer_ = m.entity(Customer.class);
    
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(customer.getName()!=null)
		{
		String name="%"+customer.getName().toLowerCase()+"%";
		predicates.add(cb.isNotNull(customers.get("name")));
		predicates.add(cb.like(cb.lower(customers.get(Customer_.getDeclaredSingularAttribute("name", String.class))),name));
		}
		createQuery.where(predicates.toArray(new Predicate[]{}));
		TypedQuery<Customer> query=entityManager.createQuery(createQuery);
		List<Customer> resultList = query.getResultList();
		return resultList;
		
		
		
	}


	public Customer findById(Long id) {
		return entityManager.find(Customer.class, id);
	}
	
	

	

	
}