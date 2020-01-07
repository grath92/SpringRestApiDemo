package com.gkrath.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "zip_code")
	private String zip_code;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "job_title")
	private String job_title;
	
	@Column(name = "company_name")
	private String company_name;
	
	
	
	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getZip_code() {
		return zip_code;
	}



	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getJob_title() {
		return job_title;
	}



	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}



	public String getCompany_name() {
		return company_name;
	}



	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}



	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", mobile="
				+ mobile + ", email=" + email + ", gender=" + gender
				+ ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", zip_code=" + zip_code
				+ ", city=" + city + ", country=" + country + ", city=" + city + ", job_title=" + job_title
				+ ", company_name=" + company_name + "]";
	}
}
