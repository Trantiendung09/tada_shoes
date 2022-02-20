package edu.poly.hello.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="product")
public class SanPham {
	//`id`, `name`, `photo_id`, `brand_id`, `category_id`, `color`, `size`, `price`, `discount`, `note`, `quantity`, `updated_at`
	@Id
	@GeneratedValue
	int id;
	String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "photo_id", referencedColumnName = "id")
	PhoTo photo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	Brand brand;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	Category category;
	String color;
	String size;
	int price;
	int discount;
	String note;
	public SanPham() {
		super();
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
	public PhoTo getPhoto() {
		return photo;
	}
	public void setPhoto(PhoTo photo) {
		this.photo = photo;
	}

	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	int quantity;
}
