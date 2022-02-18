package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



import lombok.Data;

@Entity
@Data
@Table(name = "carrr")
public class Car {
	@NotNull
	private String car_name;
	
	@NotNull
	private String car_brand;
	
	@NotNull
	private String color;
	
	@NotNull
	private String plate_number;
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_id")
	private int carid;
	
	@NotNull
	private int  capacity;
	
	@NotNull
	private int rate;
	
//	@NotNull
//	private int sp_id;
	
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name="sp_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ServiceProvider serviceProvider;
	
	private int status;
	private int quantity;
	
	


}
//	public Car() {
//		
//		
//	}
//
//	public Car( String car_name, String car_brand, String color,int capacity, String plate_number,  int rate,
//			int sp_id,int quantity, int status ) {
//		super();
//		this.car_name = car_name;
//		this.car_brand = car_brand;
//		this.color = color;
//		this.plate_number = plate_number;
//		this.capacity = capacity;
//		this.rate = rate;
//		this.sp_id = sp_id;
//		this.status = status;
//		this.quantity = quantity;
//	}
//
//
//
//	public Car(int car_id, String car_name, String car_brand, String color,int capacity, String plate_number,  int rate,
//			int sp_id,int quantity, int status ) {
//		super();
//		this.car_name = car_name;
//		this.car_brand = car_brand;
//		this.color = color;
//		this.plate_number = plate_number;
//		this.car_id = car_id;
//		this.capacity = capacity;
//		this.rate = rate;
//		this.sp_id = sp_id;
//		this.status = status;
//		this.quantity = quantity;
//	}
//
//
//
//
//
//	public String getCar_name() {
//		return car_name;
//	}
//
//
//
//
//
//	public void setCar_name(String car_name) {
//		this.car_name = car_name;
//	}
//
//
//
//
//
//	public String getCar_brand() {
//		return car_brand;
//	}
//
//
//
//
//
//	public void setCar_brand(String car_brand) {
//		this.car_brand = car_brand;
//	}
//
//
//
//
//
//	public String getColor() {
//		return color;
//	}
//
//
//
//
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//
//
//
//
//	public String getPlate_number() {
//		return plate_number;
//	}
//
//
//
//
//
//	public void setPlate_number(String plate_number) {
//		this.plate_number = plate_number;
//	}
//
//
//
//
//
//	public int getCar_id() {
//		return car_id;
//	}
//
//
//
//
//
//	public void setCar_id(int car_id) {
//		this.car_id = car_id;
//	}
//
//
//
//
//
//	public int getCapacity() {
//		return capacity;
//	}
//
//
//
//
//
//	public void setCapacity(int capacity) {
//		this.capacity = capacity;
//	}
//
//
//
//
//
//	public int getRate() {
//		return rate;
//	}
//
//
//
//
//
//	public void setRate(int rate) {
//		this.rate = rate;
//	}
//
//
//
//
//
//	public int getSp_id() {
//		return sp_id;
//	}
//
//
//
//
//
//	public void setSp_id(int sp_id) {
//		this.sp_id = sp_id;
//	}
//
//
//
//
//
//	public int getStatus() {
//		return status;
//	}
//
//
//
//
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//
//
//
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//
//
//
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//
//
//
//
//
//
//}
