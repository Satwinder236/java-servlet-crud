package com.cestar.model;

public class Employee {

	private int id;
	private String name;
	
	public Employee(int id, String name, String contact, String city, String email) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.city = city;
		this.email = email;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", contact=" + contact + ", city=" + city + ", email=" + email
				+ "]\n";
	}

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String contact;
	private String city;
	private String email;
	
}
