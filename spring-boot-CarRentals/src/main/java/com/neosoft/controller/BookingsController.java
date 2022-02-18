package com.neosoft.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Bookings;
import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;

import com.neosoft.repository.ServiceProviderRepository;
import com.neosoft.service.BookingServiceImpl;
import com.neosoft.service.CarServiceImpl;
import com.neosoft.service.ServiceProviderServiceImpl;

@Controller
public class BookingsController {

	@Autowired
	private BookingServiceImpl bookingServiceImpl;
	
	@Autowired
	private CarServiceImpl carServiceImpl;
	
	@Autowired
	private ServiceProviderServiceImpl serviceProviderServiceImpl;
	
	@GetMapping("/bookedcars")
	public  String listBookedCars(Model model){
		List<Bookings> b=bookingServiceImpl.getAllBookedCars();

		
		return "view_cars";
	}
	
	
	
	
	@GetMapping("/bookedcarsBySpid")
	public  String BookedCars(Model model,HttpServletRequest request){
		
	int spid=(int) request.getSession().getAttribute("sprid");
		
		//model.addAttribute("spid",spid);
	model.addAttribute("bookings",bookingServiceImpl.getBookedCarsBySpid(serviceProviderServiceImpl.getServiceProviderById(spid)));

		
		return "view_bookedcars";
	}
	
	@GetMapping("/addCar")
	public String createBookCarForm(Model model,HttpServletRequest request) {
		
		Bookings booking = new Bookings();
		Object spid=request.getSession().getAttribute("sprid");
		model.addAttribute("booking", booking);
		model.addAttribute("spid",spid);
		
		return "book_car";
	}
	
	@PostMapping("/bookcar/{id}")
	public String saveBookedCar(@ModelAttribute("booking") Bookings bookings,@PathVariable ServiceProvider id) {
		int carid=bookings.getCar().getCarid();
//		System.out.println(carServiceImpl.checkBooking(carid));
		
		boolean checkstatus=carServiceImpl.checkBooking(carid); //if true available
		
		System.out.println("Check status: "+checkstatus);
		
		java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
		bookings.setBookingdate(currentDate);
		bookings.setReturn_status("No");
		bookings.setServiceProvider(id);
		
		if(checkstatus){
			int status=0;
//		System.out.println("stat"+bookingServiceImpl.saveBookedCars(bookings));
	status=bookingServiceImpl.saveBookedCars(bookings); //get 1 if inserted
//	System.out.println("after query"+status);
	if(status>0){
		
//System.out.println("update me stat"+carServiceImpl.updateStatusById(carServiceImpl.getCar(carid)+1, carid));
	status=carServiceImpl.updateStatusById(carServiceImpl.getCar(carid)+1, carid); //updating as booked that is 1
	}
		}
		return "redirect:/cars";
	
				
			
			
	}
	
	@GetMapping("/returncar/{bid}/{cid}")
	public String returnCar(@PathVariable Integer bid,@PathVariable Car cid) {
		int status=0;
		System.out.println("return ku aya");
	status=bookingServiceImpl.updateBookingSetStatusByBidAndCid(bid,cid);
	
	if(status>0){
		status=carServiceImpl.updateStatusById(0, cid.getCarid()); // making available by updating status as 0 
	}
	
		
		return "redirect:/bookedcarsBySpid";
	}
	
	
//	
//	
//	
//	
//	@GetMapping("/serviceproviders/edit/{id}")
//	public String editServiceProvidersForm(@PathVariable Integer id, Model model) {
//		
//		model.addAttribute("serviceProviders",serviceProviderServiceImpl.getServiceProviderById(id));
//		
//		return "edit_serviceProvider";
//	}
//	
//	@PostMapping("/serviceprovider/{id}")
//	public String updateStudent(@PathVariable Integer id, 
//			@ModelAttribute("serviceProviders") ServiceProvider serviceProviders,	Model model) {
//		
//		ServiceProvider existingServiceProvider = serviceProviderServiceImpl.getServiceProviderById(id);
//		existingServiceProvider.setSpid(id);
//		existingServiceProvider.setName(serviceProviders.getName());
//		existingServiceProvider.setEmail(serviceProviders.getEmail());
//		existingServiceProvider.setPassword(serviceProviders.getPassword());	
//		existingServiceProvider.setMobile(serviceProviders.getMobile());	
//		serviceProviderServiceImpl.updateServiceProvider(existingServiceProvider);
//		
//		return "redirect:/serviceproviders";
//	}
//	
//	@GetMapping("/deleteCar/{id}")
//	public String deleteCar(@PathVariable Integer id) {
//		
//	carServiceImpl.deleteCarById(id);
//		
//		return "redirect:/cars";
//	}
	
}