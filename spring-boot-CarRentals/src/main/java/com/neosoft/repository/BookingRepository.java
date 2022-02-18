package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.model.Bookings;
import com.neosoft.model.Car;
import com.neosoft.model.ServiceProvider;




public interface BookingRepository extends JpaRepository<Bookings, Integer> {
	
List<Bookings> findByserviceProvider(ServiceProvider id);

//select * from booking  where sp_id=? order by booking_date desc

@Transactional
@Modifying
//update booking set return_status='yes' where booking_id=? and car_id=?
@Query("UPDATE Bookings b SET b.return_status='yes' WHERE b.booking_id=:bid and b.car=:cid")
int updateBookingSetStatusByBidAndCid(@Param("bid") int bookingid, @Param("cid") Car carid);



}
