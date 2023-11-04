package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voter_table")
public class Voter
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="voter_name",nullable=false,length = 50)
	private String name;
	
	@Column(name="voter_gender",nullable=false,length = 10)
	private String gender;
	
	@Column(name="voter_dob",nullable=false,length = 20)
	private String dateofbirth;
	
	@Column(name="voter_email",nullable=false,unique = true,length = 30)
	private String email;
	
	@Column(name="voter_password",nullable=false,length = 30)
	private String password;
	
	@Column(name="voter_location",nullable=false)
	private String location;
	
	@Column(name="voter_contact",nullable=false,unique = true)
	private String contact;
	
	@Column(name="voter_status",nullable=false)
	private boolean active; // true or false
	
	@Column(name = "voted_to", nullable = true)
	private String voted_to;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getVoted_to() {
		return voted_to;
	}

	public void setVoted_to(String voted_to) {
		this.voted_to = voted_to;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", gender=" + gender + ", dateofbirth=" + dateofbirth + ", email="
				+ email + ", password=" + password + ", location=" + location + ", contact=" + contact + ", active="
				+ active + ", voted_to=" + voted_to + "]";
	}
}
