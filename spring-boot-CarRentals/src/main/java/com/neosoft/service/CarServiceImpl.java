package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;
import com.neosoft.repository.CarRepository;
import com.neosoft.repository.ServiceProviderRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}
	
	
	
	@Override
	public Car getCarById(Integer id) {
		int booked=0;
	return	carRepository.findById(id).get();
		 
			
	}

	@Override
	public Car saveCar(Car car) {
		// TODO Auto-generated method stub
		return carRepository.save(car);
	}

	@Override
	public int getCar(Integer id) {
		int booked=0;
	return	carRepository.findById(id).get().getStatus();
		 
			
	}
	@Override
	public Car updateCar(Car car) {
		// TODO Auto-generated method stub
		return carRepository.save(car);
	}
	
	@Override
	public boolean checkBooking(Integer carid) {
		System.out.println("checkbook upper");
		boolean status=false;
		System.out.println( "aaaaaaaaaaja"+carRepository.findByCaridAndQuantityGreaterThanStatus(carid));//means available
		if( carRepository.findByCaridAndQuantityGreaterThanStatus(carid) != null)
			status=true;
		return status;
	}
	
	@Override
	public int updateStatusById(Integer status, Integer carid) {
		// TODO Auto-generated method stub
		return carRepository.updateCarSetStatusForId(status, carid);
	}
	

	@Override
	public void deleteCarById(Integer id) {
		// TODO Auto-generated method stub
		carRepository.deleteById(id);
	}



	@Override
	public List<Car> getAllCarsBySpid(ServiceProvider spid) {
		System.out.println("getAllCarsBySpid ke ander");
		return carRepository.findByServiceProvider(spid);
	}

//	@Override
//	public Car saveCarUsingSpid(String car_name, String car_brand, String color, int capacity, String plate_number,
//			int rate, int sp_id, int quantity, int status) {
//		// TODO Auto-generated method stub
//		return carRepository.saveCarUsingSpid(car_name, car_brand, color, capacity, plate_number, rate, sp_id, quantity, status);
//	}




}

//@Override
//public List<ServiceProvider> getAllServiceProviders() {
//	// TODO Auto-generated method stub
//	return serviceProviderRepository.findAll();
//}
//
//@Override
//public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
//	// TODO Auto-generated method stub
//	return serviceProviderRepository.save(serviceProvider);
//}
//
//@Override
//public ServiceProvider getServiceProviderById(Integer id) {
//	// TODO Auto-generated method stub
//	return serviceProviderRepository.findById(id).get();
//}
//
//@Override
//public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) {
//	// TODO Auto-generated method stub
//	return serviceProviderRepository.save(serviceProvider);
//}
//
//@Override
//public void deleteServiceProviderById(Integer id) {
//	// TODO Auto-generated method stub
//	serviceProviderRepository.deleteById(id);
//}