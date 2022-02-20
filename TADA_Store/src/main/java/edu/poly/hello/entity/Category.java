package edu.poly.hello.entity;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity(name="category")
public class Category {
	@Id
	@GeneratedValue
	int id;
	String name;
	String logo;
	public Category() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Set<SanPham> getSanpham() {
		return sanpham;
	}
	public void setSanpham(Set<SanPham> sanpham) {
		this.sanpham = sanpham;
	}
	@OneToMany(mappedBy = "category")
	Set<SanPham> sanpham;
}
