package edu.poly.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.hello.dao.blogpost_Dao;
import edu.poly.hello.entity.BlogPost;

@Service
public class Blogpost_service {
	@Autowired
	blogpost_Dao blogpost_dao;
	public void save(BlogPost blogPost)
	{
		blogpost_dao.save(blogPost);
	}
	public BlogPost getid(int id)
	{
		return blogpost_dao.getById(id);
	}

}
