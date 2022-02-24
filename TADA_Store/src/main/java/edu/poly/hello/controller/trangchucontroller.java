package edu.poly.hello.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.poly.hello.entity.Category;
import edu.poly.hello.entity.SanPham;
import edu.poly.hello.entity.cart;
import edu.poly.hello.service.SanPhamServiceImp;
import edu.poly.hello.service.category_service;

@Controller
@SessionAttributes("shoppingCart")
@RequestMapping("/")
public class trangchucontroller {
	@Autowired
	SanPhamServiceImp sanPham_Service;
	@Autowired
	category_service category_service;

//	@GetMapping("/home")
//	public String home(Model lo) {
//
//		Pageable pageable = PageRequest.of(3, 4);
//		List<SanPham> sanPhams = (List<SanPham>) sanPham_Service.getAllUser(pageable);
//		List<Category> category = category_service.test();
//		String s = "dung hhh";
//		lo.addAttribute("sps", sanPhams);
//		lo.addAttribute("spss", s);
//		lo.addAttribute("category", category);
//		return "trangchu";
//	}
	@GetMapping(value = "/sanphamloai")
	public String sanphamloai(@RequestParam(value = "ca_id") String ca_id, Model lo) {
		System.out.println(ca_id);
		List<SanPham> sanPhams = (List<SanPham>) sanPham_Service.getsanpham_loai(Integer.parseInt(ca_id));
		lo.addAttribute("sps", sanPhams);
		List<Category> category = category_service.test();
		lo.addAttribute("category", category);
		return "test";
	}
	@GetMapping("/parameters/countries/page/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<SanPham> page = sanPham_Service.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<SanPham> sanPhams = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("sps", sanPhams);
		List<Category> category = category_service.test();
		model.addAttribute("category", category);
		return "trangchu";
	}
	@GetMapping("/parameters/countries")
	public String getAllPages(Model model) {
		return getOnePage(model, 1);
	}
	@GetMapping("/kk/{x}")
	public String search(Model m, @PathVariable("x") String x) {
		List<SanPham> sanPhams = sanPham_Service.search_sanpham(x);
		List<Category> category = category_service.test();
		m.addAttribute("category", category);
		m.addAttribute("sps", sanPhams);
		return "search_product";
	}
	@GetMapping("/addtocard")
	@ResponseBody
	public String addtocard(@RequestParam("id") String id,  Model model,  HttpSession session )
	{
		HashMap<Integer, cart> shoppingCart = (HashMap<Integer, cart>) session.getAttribute("myCartItems");
		
        if (shoppingCart == null) {
        	shoppingCart = new HashMap<>();
        }
        SanPham product = sanPham_Service.findById(id);
        int i=Integer.parseInt(id);
        if (product != null) 
        {
            if (shoppingCart.containsKey(i)) {
                cart item = shoppingCart.get(i);
                item.setSanpham(product);
                item.setQuantity(item.getQuantity() + 1);
                shoppingCart.put(i, item);
            }
            else {
                cart item = new cart();
                item.setSanpham(product);
                item.setQuantity(1);
                shoppingCart.put(i, item);
            }
        }
        session.setAttribute("myCartItems", shoppingCart);
        session.setAttribute("myCartNum", shoppingCart.size());
        return "s";
	}
	@GetMapping("/test")
	public String test(Model m, HttpSession session) {

	    // store data in session
		HashMap<Integer, cart> shoppingCart=(HashMap<Integer, cart>) session.getAttribute("myCartItems");
		m.addAttribute("Cart",shoppingCart);
	    return "home";
	}
	@GetMapping("/updatecart")
	@ResponseBody
	public ModelAndView updatecart(HttpSession session, @RequestParam("id") String id, @RequestParam("quantity") String quantity)
	{
		ModelAndView mav = new ModelAndView();
		HashMap<Integer, cart> shoppingCart = (HashMap<Integer, cart>) session.getAttribute("myCartItems");
		System.out.println(quantity); 
		
		try {
		int i=Integer.parseInt(id);
		int sl=Integer.parseInt(quantity);
		SanPham product=sanPham_Service.findById(id);
		if(shoppingCart.containsKey(i))
		{
			cart item=shoppingCart.get(i);
			shoppingCart.remove(i);
			item.setQuantity(sl);
			shoppingCart.put(i, item);
		}
		} catch (NumberFormatException e){
			
		    System.out.println("not a number"); 
		}
		session.removeAttribute("myCartItems");
		session.setAttribute("myCartItems", shoppingCart);
		mav.setViewName("cart");
		mav.addObject("Cart",shoppingCart);
		return mav;
	}
	@GetMapping("/deletecart")
	@ResponseBody
	public ModelAndView deletecart(HttpSession session, @RequestParam("id") String id)
	{
		ModelAndView mav = new ModelAndView();
		HashMap<Integer, cart> shoppingCart = (HashMap<Integer, cart>) session.getAttribute("myCartItems");
		
		try {
		int i=Integer.parseInt(id);
		SanPham product=sanPham_Service.findById(id);
		if(shoppingCart.containsKey(i))
		{
			shoppingCart.remove(i);
			
		}
		} catch (NumberFormatException e){
			
		    System.out.println("not a number"); 
		}
		session.removeAttribute("myCartItems");
		session.setAttribute("myCartItems", shoppingCart);
		mav.setViewName("cart");
		mav.addObject("Cart",shoppingCart);
		return mav;
	}

	
}
