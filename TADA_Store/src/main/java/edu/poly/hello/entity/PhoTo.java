package edu.poly.hello.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="photo")
public class PhoTo implements Serializable{
	@Id
	@GeneratedValue
	int id;
	String photo_n1;
	String photo_n2;
	public int getId() {
		return id;
	}
	public PhoTo() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoto_n1() {
		return photo_n1;
	}
	public void setPhoto_n1(String photo_n1) {
		this.photo_n1 = photo_n1;
	}
	public String getPhoto_n2() {
		return photo_n2;
	}
	public void setPhoto_n2(String photo_n2) {
		this.photo_n2 = photo_n2;
	}
	public String getPhoto_n3() {
		return photo_n3;
	}
	public void setPhoto_n3(String photo_n3) {
		this.photo_n3 = photo_n3;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	String photo_n3;
	@OneToOne(mappedBy = "photo")
	SanPham sanpham;
}
