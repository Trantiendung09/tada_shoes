package edu.poly.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.hello.dao.Customer_Dao;
import edu.poly.hello.entity.Customer;

@Service
public class Customer_service {
	@Autowired
	Customer_Dao customer_Dao;
 public void Add_customer(Customer customer)
 {
	 customer_Dao.save(customer);
 }
}
