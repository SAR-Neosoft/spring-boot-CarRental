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

import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;

import com.neosoft.repository.ServiceProviderRepository;
import com.neosoft.service.CarServiceImpl;
import com.neosoft.service.ServiceProviderServiceImpl;

@Controller
public class CarController {

	@Autowired
	private CarServiceImpl carServiceImpl;
	
	@Autowired
	private ServiceProviderServiceImpl serviceProviderServiceImpl;
	
	@GetMapping("/car")
	public  String listCars(Model model){
		
	
		
	model.addAttribute("cars",carServiceImpl.getAllCars());
	
		
		return "view_cars";
	}
	
	@GetMapping("/cars")
	public  String listCarsByid(Model model,HttpServletRequest request){
		
	int	spid= (int) request.getSession().getAttribute("sprid");
		System.out.println("cars ke under");
	model.addAttribute("cars",carServiceImpl.getAllCarsBySpid(serviceProviderServiceImpl.getServiceProviderById(spid)));
	
		
		return "view_cars";
	}
	
	
	@GetMapping("/car/add")
	public String createCarForm(Model model,HttpServletRequest request) {
		
		Car car = new Car();
		Object spid=request.getSession().getAttribute("sprid");
		model.addAttribute("car", car);
		model.addAttribute("spid",spid);
		
		return "add_car";
	}
	
	@PostMapping("/cars/{id}")
	public String saveCar(@ModelAttribute("car") Car car,@PathVariable ServiceProvider id) {
		
	
		car.setServiceProvider(id);
		car.setQuantity(1);
		car.setStatus(0);
		carServiceImpl.saveCar(car);
		
		return "redirect:/cars";
		
	}

//	
	@GetMapping("/deleteCar/{id}")
	public String deleteCar(@PathVariable Integer id) {
		
	carServiceImpl.deleteCarById(id);
		
		return "redirect:/cars";
	}
	
}