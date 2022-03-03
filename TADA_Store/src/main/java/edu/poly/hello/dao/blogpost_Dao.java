package edu.poly.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.hello.entity.BlogPost;

@Repository
public interface blogpost_Dao extends JpaRepository<BlogPost, Integer>{
}
