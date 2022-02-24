package edu.poly.hello.entity;

import java.io.Serializable;

public class cart implements Serializable{
	private static final long serialVersionUID = 3820550862135963739L;
//	private int price;
//	private int quantity;
//	public cart()
//	{
//		
//	}
//	public cart(int price, int quantity) {
//		this.price = price;
//		this.quantity = quantity;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	SanPham sanpham;
	int quantity;
	public cart() {
		super();
	}
	public cart(SanPham sanpham, int quantity) {
		super();
		this.sanpham = sanpham;
		this.quantity = quantity;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
