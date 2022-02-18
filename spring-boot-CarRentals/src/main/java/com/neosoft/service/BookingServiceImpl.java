package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Bookings;
import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;
import com.neosoft.repository.BookingRepository;
import com.neosoft.repository.CarRepository;
import com.neosoft.repository.ServiceProviderRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<Bookings> getAllBookedCars() {
		
		return bookingRepository.findAll();
	}

	@Override
	public int saveBookedCars(Bookings car) {
		// TODO Auto-generated method stub
	
	if(  bookingRepository.save(car) != null)
	    return 1;
	else 
		return 0;
	}

	@Override
	public Bookings getBookedCarById(Integer id) {
		
		return bookingRepository.findById(id).get();
	}

	@Override
	public Bookings updateBookings(Bookings car) {
		// TODO Auto-generated method stub
		return bookingRepository.save(car);
	}





	@Override
	public void deleteBookedCarById(Integer id) {
		bookingRepository.deleteById(id);
		
	}

	@Override
	public List<Bookings> getBookedCarsBySpid(ServiceProvider id) {
		System.out.println("aagaaaaaaaaaaaaaaaa");
		System.out.println(bookingRepository.findByserviceProvider(id));
		return bookingRepository.findByserviceProvider(id);
	}

	@Override
	public int updateBookingSetStatusByBidAndCid(int bid, Car carid) {
		System.out.println("update book return me");
		System.out.println("return "+ bookingRepository.updateBookingSetStatusByBidAndCid(bid, carid));
		return bookingRepository.updateBookingSetStatusByBidAndCid(bid, carid);
	
	}

//	@Override
//	public List<Car> getAllCars() {
//		// TODO Auto-generated method stub
//		return carRepository.findAll();
//	}
//
//	@Override
//	public Car saveCar(Car car) {
//		// TODO Auto-generated method stub
//		return carRepository.save(car);
//	}
//
//	@Override
//	public Car getCar(Integer id) {
//		// TODO Auto-generated method stub
//		return carRepository.findById(id).get();
//	}
//	@Override
//	public Car updateCar(Car car) {
//		// TODO Auto-generated method stub
//		return carRepository.save(car);
//	}
//
//	@Override
//	public void deleteCarById(Integer id) {
//		// TODO Auto-generated method stub
//		carRepository.deleteById(id);
//	}





}

