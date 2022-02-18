package com.neosoft.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "serviceprovider")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sp_id")
	private int spid;
	private String name;
	private String email;
	private String password;
	private long mobile;

//	@OneToMany(fetch = FetchType.LAZY,mappedBy = "serviceProvider")
//	@OneToMany(mappedBy = "serviceProvider")
//	private List<Car> cars;
	
	
	
	
	
//	
//	public ServiceProvider() {
//	}
//
//	public ServiceProvider(int id, String name, String email, String password, long mobile) {
//		super();
//		this.sp_id = id;
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.mobile = mobile;
//	}
//	
//	
//
//
//	public ServiceProvider(String name, String email, String password, long mobile) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.mobile = mobile;
//	}
//
//	public int getId() {
//		return sp_id;
//	}
//
//	public void setId(int id) {
//		this.sp_id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public long getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(long mobile) {
//		this.mobile = mobile;
//	}

}
