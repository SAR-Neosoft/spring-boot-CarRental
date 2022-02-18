package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.ServiceProvider;


public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

	ServiceProvider findByEmailAndPasswordAndSpid(String email,String password,int spid );
}
