package edu.poly.hello.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.hello.entity.SanPham;
@Repository
public interface SanPhamDao extends JpaRepository<SanPham, Integer>{
	@Query("SELECT e FROM product  e ORDER BY e.price DESC")
	 List<SanPham> findAllOrderByPriceDesc(Pageable pageable);
	@Query("SELECT e FROM product  e join  e.category d where  d.id=?1 ")
	 List<SanPham> getsanpham_loai(int id);
	@Query("select e from product e where e.name like ?1")
	List<SanPham>search_sanpham(String name);
//	@Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name", nativeQuery = true)
//    User findUserByNamedParamsNative(@Param("status") Integer status, @Param("name") String name);
	@Query("select e from product e where e.id = ?1")
	SanPham getById(int id);
}
