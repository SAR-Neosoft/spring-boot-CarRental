package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.ServiceProvider;
import com.neosoft.repository.ServiceProviderRepository;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	@Override
	public List<ServiceProvider> getAllServiceProviders() {
		// TODO Auto-generated method stub
		return serviceProviderRepository.findAll();
	}

	@Override
	public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		return serviceProviderRepository.save(serviceProvider);
	}

	@Override
	public ServiceProvider getServiceProviderById(Integer id) {
		// TODO Auto-generated method stub
		return serviceProviderRepository.findById(id).get();
	}

	@Override
	public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) {
		// TODO Auto-generated method stub
		return serviceProviderRepository.save(serviceProvider);
	}

	@Override
	public void deleteServiceProviderById(Integer id) {
		// TODO Auto-generated method stub
		serviceProviderRepository.deleteById(id);
	}

	@Override
	public ServiceProvider authenticate(String email, String password,Integer spid) {
		
		return serviceProviderRepository.findByEmailAndPasswordAndSpid(email, password,spid);
	}

}
