package edu.poly.hello.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="orrder")
public class Orrder {
	@Id
	@GeneratedValue
	int id;
	int status;
	float total;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	Customer customer;
	@OneToMany(mappedBy = "order")
	Set<Order_detail> order_details;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total2) {
		this.total = total2;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Order_detail> getOrder_details() {
		return order_details;
	}
	public void setOrder_details(Set<Order_detail> order_details) {
		this.order_details = order_details;
	}
}
