package edu.poly.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.hello.dao.categoryDao;
import edu.poly.hello.entity.Category;

@Service
public class category_service {
	@Autowired
	categoryDao caDao;
	public List<Category> test()
	{
		return caDao.test();
	}
 
}
