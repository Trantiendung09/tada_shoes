package edu.poly.hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="blogpost")
public class BlogPost {
	@Id
	@GeneratedValue
	int id;
	private String title;
	private String body;	

	public String getBody() {
		return body;
	}
	public String getTitle() {
		return title;
	}
	public void setBody(String body) {
		this.body = body;
	}
		public void setTitle(String title) {
		this.title = title;
	}
	
//    public String toString() {
//		return ReflectionToStringBuilder.toString(this);
//	}	

}
