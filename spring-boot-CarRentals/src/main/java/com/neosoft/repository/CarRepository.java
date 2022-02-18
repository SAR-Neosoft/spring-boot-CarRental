package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;




public interface CarRepository extends JpaRepository<Car, Integer> {
	
	
		@Query("Select c from Car c WHERE c.carid=:id and c.quantity>c.status")
		Car findByCaridAndQuantityGreaterThanStatus(int id);

	//boolean findByCaridAndQuantityGreaterThanStatus(int id);
	//select * from car where car_id=? and quantity>status
	
	@Transactional
	@Modifying
	//update car set status=? where car_id=?
	@Query("UPDATE Car c SET c.status=:stat WHERE c.carid=:id")
	int updateCarSetStatusForId(@Param("stat") int status, @Param("id")int carid);
	
	
	//select * from car where sp_id=?
	//@Query("Select c from Car c WHERE c.serviceProvider=:spid")
	List<Car> findByServiceProvider(ServiceProvider spid);
	
}
