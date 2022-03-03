package edu.poly.hello.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="customer")
public class Customer implements Serializable{
	@Id
	@GeneratedValue
	int id;
	String name;
	String fullname;
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String address) {
		this.adress = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Orrder> getOrder() {
		return order;
	}
	public void setOrder(Set<Orrder> order) {
		this.order = order;
	}
	public Customer() {
		
	}
	String phone;
	String adress;
	String email;
	@OneToMany(mappedBy = "customer")
	Set<Orrder> order;
}
