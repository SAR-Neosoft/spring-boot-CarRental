package com.neosoft.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.neosoft.model.Bookings;
import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;





public interface BookingService {

List<Bookings> getAllBookedCars();
	
int saveBookedCars(Bookings car);
	
Bookings getBookedCarById(Integer id);
	
Bookings updateBookings(Bookings car);

List<Bookings> getBookedCarsBySpid(ServiceProvider id);

int updateBookingSetStatusByBidAndCid(int bid,Car carid);
//Car saveCarUsingSpid(String car_name,String car_brand,String color,int capacity,String plate_number,int rate,int sp_id,int quantity,int status);
	
	void deleteBookedCarById(Integer id);
}
