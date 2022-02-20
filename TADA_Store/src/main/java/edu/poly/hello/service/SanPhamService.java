package edu.poly.hello.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.poly.hello.entity.SanPham;

public interface SanPhamService {
	List<edu.poly.hello.entity.SanPham> getAllUser(Pageable pageable); 
	
}
