package edu.poly.hello.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.hello.entity.Brand;
import edu.poly.hello.entity.Category;

@Repository
public interface categoryDao extends CrudRepository<Brand, Integer>{
	@Query("SELECT e FROM category  e ")
	List<Category> test();
}
