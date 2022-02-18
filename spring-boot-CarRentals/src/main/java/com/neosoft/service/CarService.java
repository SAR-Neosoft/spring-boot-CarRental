package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;




public interface CarService {

List<Car> getAllCars();
	
Car saveCar(Car car);
	
int getCar(Integer id);
	
Car updateCar(Car car);

//Car saveCarUsingSpid(String car_name,String car_brand,String color,int capacity,String plate_number,int rate,int sp_id,int quantity,int status);

boolean checkBooking(Integer carid);

int updateStatusById(Integer status,Integer carid);

	void deleteCarById(Integer id);

	Car getCarById(Integer id);
	
	List<Car> getAllCarsBySpid(ServiceProvider spid);
}
