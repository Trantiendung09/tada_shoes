package edu.poly.hello.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.poly.hello.entity.Brand;
import edu.poly.hello.entity.Category;
import edu.poly.hello.entity.Orrder;
import edu.poly.hello.entity.Order_detail;
import edu.poly.hello.entity.SanPham;
@Repository
public interface Order_Dao extends JpaRepository<Orrder, Integer>{
//	@Query("SELECT e FROM order  e ")
//	 List<Order> test();
}
