package edu.poly.hello.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.poly.hello.entity.Category;
import edu.poly.hello.entity.SanPham;
import edu.poly.hello.service.SanPhamServiceImp;
import edu.poly.hello.service.category_service;


@Controller
public class trangchucontroller {
	@Autowired
	SanPhamServiceImp sanPham_Service;
	@Autowired
	category_service category_service;
	@GetMapping("/home")
	public String home(Model lo)
	{
		
		Pageable pageable = PageRequest.of(3, 4);
		List<SanPham> sanPhams=(List<SanPham>) sanPham_Service.getAllUser(pageable);
		List<Category> category=category_service.test();
		String s="dung hhh";
		lo.addAttribute("sps", sanPhams);
		lo.addAttribute("spss", s);
		lo.addAttribute("category", category);
		return "trangchu";
	}
	@GetMapping(value="/sanphamloai")
	public String sanphamloai(@RequestParam(value= "ca_id") String ca_id, Model lo)
	{
		System.out.println(ca_id);
		List<SanPham> sanPhams=(List<SanPham>) sanPham_Service.getsanpham_loai(Integer.parseInt(ca_id));
		lo.addAttribute("sps", sanPhams);
		List<Category> category=category_service.test();
		lo.addAttribute("category", category);
		return "test";
	}
	@GetMapping("/pt")
	public String posts(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size, Model model, Model lo) {
        model.addAttribute("posts", sanPham_Service.getPage(pageNumber, size));
        List<Category> category=category_service.test();
        lo.addAttribute("category", category);
        return "page";
    }
	@GetMapping("/parameters/countries/page/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage){
	    Page<SanPham> page = sanPham_Service.findPage(currentPage);
	    int totalPages = page.getTotalPages();
	    long totalItems = page.getTotalElements();
	    List<SanPham> sanPhams = page.getContent();
	  
	    model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("sps", sanPhams);
	    List<Category> category=category_service.test();
        model.addAttribute("category", category);
	    return "trangchu";
	}
	@GetMapping("/parameters/countries")
	public String getAllPages(Model model){
	    return getOnePage(model, 1);
	}
	@GetMapping("/search/{name}")
	public String search(@PathVariable String name) 
		    throws Exception {
		  System.out.println(name);
		  return "redirect:/kk";
	}
	@GetMapping("/kk")
	@ResponseBody
	public String dd(@RequestParam("name") String x, Model m){
		m.addAttribute("x",x);
		System.out.println(x);
	    return "tt";
	}
}
