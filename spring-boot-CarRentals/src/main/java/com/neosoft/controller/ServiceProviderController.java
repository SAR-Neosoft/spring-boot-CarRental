package com.neosoft.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.ServiceProvider;

import com.neosoft.repository.ServiceProviderRepository;
import com.neosoft.service.ServiceProviderServiceImpl;

@Controller
public class ServiceProviderController {

	@Autowired
	private ServiceProviderServiceImpl serviceProviderServiceImpl;
	
	@GetMapping("/serviceproviders")
	public  String listServiceProviders(Model model){
	model.addAttribute("serviceProviders",serviceProviderServiceImpl.getAllServiceProviders());
		
		return "view_serviceProvider";
	}
	
	@GetMapping("/serviceproviders/add")
	public String createServiceProviderForm(Model model) {
		
		ServiceProvider serviceProviders = new ServiceProvider();
		model.addAttribute("serviceProviders", serviceProviders);
		
		return "create_serviceProvider";
	}
	
	@PostMapping("/serviceproviders")
	public String saveServiceProviders(@ModelAttribute("serviceProviders") ServiceProvider serviceProviders) {
		
		serviceProviderServiceImpl.saveServiceProvider(serviceProviders);
		
		return "redirect:/serviceproviders";
	}
	
	
	
	
	@GetMapping("/serviceproviders/edit/{id}")
	public String editServiceProvidersForm(@PathVariable Integer id, Model model) {
		
		model.addAttribute("serviceProviders",serviceProviderServiceImpl.getServiceProviderById(id));
		
		return "edit_serviceProvider";
	}
	
	@PostMapping("/serviceprovider/{id}")
	public String updateStudent(@PathVariable Integer id, 
			@ModelAttribute("serviceProviders") ServiceProvider serviceProviders,	Model model) {
		
		ServiceProvider existingServiceProvider = serviceProviderServiceImpl.getServiceProviderById(id);
		existingServiceProvider.setSpid(id);
		existingServiceProvider.setName(serviceProviders.getName());
		existingServiceProvider.setEmail(serviceProviders.getEmail());
		existingServiceProvider.setPassword(serviceProviders.getPassword());	
		existingServiceProvider.setMobile(serviceProviders.getMobile());	
		serviceProviderServiceImpl.updateServiceProvider(existingServiceProvider);
		
		return "redirect:/serviceproviders";
	}
	
	@GetMapping("/deleteserviceprovider/{id}")
	public String deleteServiceProvider(@PathVariable Integer id) {
		
		serviceProviderServiceImpl.deleteServiceProviderById(id);
		
		return "redirect:/serviceproviders";
	}
	
	
//	public static int save(ServiceProvider bean){
//		int status=0;
//		try{
//			Connection con=DB.getCon();
//			PreparedStatement ps=con.prepareStatement("insert into serviceprovider(name,password,email,mobile)"
//					+ "values(?,?,?,?)");
//			ps.setString(1,bean.getName());
//			ps.setString(2,bean.getPassword());
//			ps.setString(3,bean.getEmail());
//			ps.setLong(4,bean.getMobile());
//			status=ps.executeUpdate();
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		
//		return status;
//	}
//	public static int update(ServiceProvider bean){
//		int status=0;
//		try{
//			Connection con=DB.getCon();
//			PreparedStatement ps=con.prepareStatement("update serviceprovider set name=?,password=?,email=?,mobile=? where sp_id=?");
//			ps.setString(1,bean.getName());
//			ps.setString(2,bean.getPassword());
//			ps.setString(3,bean.getEmail());
//			ps.setLong(4,bean.getMobile());
//			ps.setInt(5,bean.getId());
//			status=ps.executeUpdate();
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		
//		return status;
//	}
//	public static List<ServiceProvider> view(){
//		List<ServiceProvider> list=new ArrayList<ServiceProvider>();
//		try{
//			Connection con=DB.getCon();
//			PreparedStatement ps=con.prepareStatement("select * from serviceprovider");
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()){
//				ServiceProvider bean=new ServiceProvider();
//				bean.setId(rs.getInt("sp_id"));
//				bean.setName(rs.getString("name"));
//				bean.setEmail(rs.getString("email"));
//				bean.setPassword(rs.getString("password"));
//				bean.setMobile(rs.getLong("mobile"));
//				list.add(bean);
//			}
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		
//		return list;
//	}
//	public static ServiceProvider viewById(int id){
//		ServiceProvider bean=new ServiceProvider();
//		try{
//			Connection con=DB.getCon();
//			PreparedStatement ps=con.prepareStatement("select * from serviceprovider where sp_id=?");
//			ps.setInt(1,id);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()){
//				bean.setId(rs.getInt(1));
//				bean.setName(rs.getString(2));
//				bean.setPassword(rs.getString(3));
//				bean.setEmail(rs.getString(4));
//				bean.setMobile(rs.getLong(5));
//			}
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		
//		return bean;
//	}
//	public static int delete(int id){
//		int status=0;
//		try{
//			Connection con=DB.getCon();
//			PreparedStatement ps=con.prepareStatement("delete from serviceprovider where sp_id=?");
//			ps.setInt(1,id);
//			status=ps.executeUpdate();
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		
//		return status;
//	}
//
//	public static boolean authenticate(String email,String password,int sprid){
//		boolean status=false;
//		try{
//			Connection con=DB.getCon();
//			PreparedStatement ps=con.prepareStatement("select * from serviceprovider where email=? and password=? and sp_id=?");
//			ps.setString(1,email);
//			ps.setString(2,password);
//			ps.setInt(3,sprid);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()){
//				status=true;
//			}
//			con.close();
//			
//		}catch(Exception e){System.out.println(e);}
//		
//		return status;
//	}
}
