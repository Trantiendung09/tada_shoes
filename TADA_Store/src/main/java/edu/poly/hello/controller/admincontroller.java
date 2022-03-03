package edu.poly.hello.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.hello.entity.BlogPost;
import edu.poly.hello.service.Blogpost_service;

@Controller
public class admincontroller {
	
	@Autowired
	Blogpost_service blogpost_service;
	@GetMapping("/admin")
	public String home()
	{
		
		return "admin/admin";
	}
	@GetMapping("/addEditPost")
	public String addEditPost(Model model, @RequestParam("blogPostId") Optional<String> blogPostId) {		
		setDefaultBlogPost(model);					
		return "admin/admin";
	}
	

	@PostMapping("/admin/addEditPost")
	public String addEditPostSubmit(Model model, BlogPost blogPost) {
	    System.out.println("Title is " + blogPost.getTitle());
	    System.out.println("Body is " + blogPost.getBody());
	    blogpost_service.save(blogPost);
		return "admin/admin";
	}

	
	private void setDefaultBlogPost(Model model) {
		BlogPost blogPost = new BlogPost();		
		model.addAttribute("blogPost", blogPost);
	}
	@GetMapping("/blog")
	public String blog(Model model, @RequestParam("id") String id)
	{
		int i=Integer.parseInt(id);
		BlogPost blogPost=new BlogPost();
		blogPost=blogpost_service.getid(i);
		model.addAttribute("blog",blogPost);
		return "/admin/blog";
	}
}
