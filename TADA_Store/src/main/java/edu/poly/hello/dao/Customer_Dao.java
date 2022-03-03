package edu.poly.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.hello.entity.Customer;
@Repository
public interface Customer_Dao extends JpaRepository<Customer, Integer>{

	
}
