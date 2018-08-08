package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOlmpl implements CustomerDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create the query
		Query <Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//return the result
		List<Customer> customers = theQuery.getResultList();
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the current hibernation session
		Session currentSession = sessionFactory.getCurrentSession();
		//read data from database using pk
		currentSession.saveOrUpdate(theCustomer);
	
	}

	@Override
	public Customer getCustomers(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id = :customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
		//return null;
	}

}
