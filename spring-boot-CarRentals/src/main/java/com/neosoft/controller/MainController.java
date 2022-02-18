package com.neosoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.model.ServiceProvider;
import com.neosoft.service.ServiceProviderServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	ServiceProviderServiceImpl serviceProviderServiceImpl;
	
	@GetMapping("/index")
	public String indexForm(Model model) {
		
		return "index";
	}
	
	@PostMapping("/AdminLogin")
	public String checkAdminLogin(@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
		
	    if(email.equals("admin@admin.com") && password.equals("admin123") )  
        {  
            String msg="Hello Admin "; 
            //add a message to the model  
            model.addAttribute("message", msg);  
            
            return "redirect:/serviceproviders"; 
        } else
        	return "index";
	   
	}
	
	
	@PostMapping("/ServiceProviderLogin")
	public String checkServiceProviderLogin(@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("sprid") String sprid,Model model,HttpServletRequest request) {
		
		int spid=Integer.parseInt(sprid);
		
		System.out.println(model.addAttribute("aut",serviceProviderServiceImpl.authenticate(email, password, spid)));
     if(serviceProviderServiceImpl.authenticate(email, password, spid) != null) {
    	// System.out.println("nullllllllllllllllllllllllllllllllllllllll");
    	 request.getSession().setAttribute("sprid", spid);
    	 return "redirect:/cars";  
    	
     }
     else {
    	// System.out.println("notttttttttttttttttttttttttttttttttt");
    	 return "redirect:/index";
     }
	   
	}
	
	@PostMapping("/invalidate/session/logout")
	public String Logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index";
	}
	


	 @RequestMapping("/errorr")
	    public String handleError() {
	        //do something like logging
	        return "error";
	    }

}
