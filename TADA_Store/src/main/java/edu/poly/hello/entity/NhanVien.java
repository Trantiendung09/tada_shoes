package edu.poly.hello.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "NhanVien")
public class NhanVien implements Serializable{
	@Id
	int id;
	String tennhanvien;
	String diachi;
	int tuoi;
//	GiamDoc gd;
//	
	public String getTennhanvien() {
		return tennhanvien;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
//	public GiamDoc getGd() {
//		return gd;
//	}
//	public void setGd(GiamDoc gd) {
//		this.gd = gd;
//	}
    public NhanVien()
    {
    	
    }
//	public NhanVien(GiamDoc dg)
//	{
//		this.gd=gd;
//	}
//	public NhanVien(String tennhanvien, int tuoi) {
//		this.tennhanvien = tennhanvien;
//		this.tuoi = tuoi;
//	}
//	public void getThanhBao()
//	{
//		System.out.println("hello day la thong bao tu class nhan vien");
//	}
}
