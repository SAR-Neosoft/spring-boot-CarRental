package com.neosoft.service;

import java.util.List;

import com.neosoft.model.ServiceProvider;



public interface ServiceProviderService {

List<ServiceProvider> getAllServiceProviders();
	
ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);
	
ServiceProvider getServiceProviderById(Integer id);
	
ServiceProvider updateServiceProvider(ServiceProvider serviceProvider);

ServiceProvider authenticate(String email,String password,Integer spid);
	
	void deleteServiceProviderById(Integer id);
}
