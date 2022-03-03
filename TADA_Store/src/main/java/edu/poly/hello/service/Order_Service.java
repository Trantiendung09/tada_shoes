package edu.poly.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.hello.dao.Order_Dao;
import edu.poly.hello.entity.Brand;
import edu.poly.hello.entity.Category;
import edu.poly.hello.entity.Orrder;
import edu.poly.hello.entity.Order_detail;

@Service
public class Order_Service {
	
	@Autowired 
	Order_Dao order_Dao;
 public void save(Orrder orrder)
 {
	 order_Dao.save(orrder);
 }
}
