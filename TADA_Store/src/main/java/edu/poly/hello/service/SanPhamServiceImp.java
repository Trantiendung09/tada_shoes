package edu.poly.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.poly.hello.dao.SanPhamDao;
import edu.poly.hello.entity.SanPham;
import edu.poly.hello.pagenation.Paged;
import edu.poly.hello.pagenation.Paging;

@Service
public class SanPhamServiceImp implements SanPhamService{

	@Autowired 
	private SanPhamDao sanPhamDao;
	@Override
	public List<SanPham> getAllUser(Pageable pageable) {
		// TODO Auto-generated method stub
		return  sanPhamDao.findAllOrderByPriceDesc( pageable);
	}
	public List<SanPham> getsanpham_loai(int id)
	{
		
		return sanPhamDao.getsanpham_loai(id);
	}
	public Paged<SanPham> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size);
        Page<SanPham> postPage = sanPhamDao.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }
	public Page<SanPham> findPage(int pageNumber){
	    Pageable pageable = PageRequest.of(pageNumber - 1,5);
	    return sanPhamDao.findAll(pageable);
	    
	}
}
