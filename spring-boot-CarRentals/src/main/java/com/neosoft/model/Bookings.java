package com.neosoft.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;


@Entity
@Data
@Table(name = "booking2")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	
	@OneToOne(fetch = FetchType.LAZY) //fetch only when we ask
	@JoinColumn(name="sp_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ServiceProvider serviceProvider;
	//private int sp_id;
	
	@OneToOne(fetch = FetchType.LAZY) //fetch only when we ask
	@JoinColumn(name="car_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car car;
//	private int car_id;
	
	private String cust_name;
	private long cust_mobile;
	@Column(name = "booking_date")
	private Date bookingdate;
	private String return_status;
	
}

//	public Bookings() {
//	}
//
//
//
//	public Bookings(String cust_name, long cust_mobile,int sp_id, int car_id) {
//		
//		this.sp_id = sp_id;
//		this.car_id = car_id;
//		this.cust_name = cust_name;
//		this.cust_mobile = cust_mobile;
//		
//	}
//
//
//	public Bookings(int booking_id, String cust_name, long cust_mobile,int sp_id, int car_id) {
//		super();
//		this.booking_id = booking_id;
//		this.sp_id = sp_id;
//		this.car_id = car_id;
//		this.cust_name = cust_name;
//		this.cust_mobile = cust_mobile;
//		
//	}
//
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
//
//	public void setCar_id(int car_id) {
//		this.car_id = car_id;
//	}
//
//
//
//
//
//
//	public int getBooking_id() {
//		return booking_id;
//	}
//
//
//
//	public void setBooking_id(int booking_id) {
//		this.booking_id = booking_id;
//	}
//
//
//
//	public int getSp_id() {
//		return sp_id;
//	}
//
//
//
//	public void setSp_id(int sp_id) {
//		this.sp_id = sp_id;
//	}
//
//
//
//	public String getCust_name() {
//		return cust_name;
//	}
//
//
//
//	public void setCust_name(String cust_name) {
//		this.cust_name = cust_name;
//	}
//
//
//
//	public long getCust_mobile() {
//		return cust_mobile;
//	}
//
//
//
//	public void setCust_mobile(long cust_mobile) {
//		this.cust_mobile = cust_mobile;
//	}
//
//
//
//	public Date getBooking_date() {
//		return booking_date;
//	}
//
//
//
//	public void setBooking_date(Date booking_date) {
//		this.booking_date = booking_date;
//	}
//
//
//
//	public String getReturn_status() {
//		return return_status;
//	}
//
//
//
//	public void setReturn_status(String return_status) {
//		this.return_status = return_status;
//	}
//
//
//
//}
