package com.example.AeroplaneTicket.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;

import com.example.AeroplaneTicket.entity.Aeroplane;

import jakarta.transaction.Transactional;


public interface AeroplaneRepository extends JpaRepository<Aeroplane,Integer>{
	@Query("select f from Aeroplane f")
	   public List<Aeroplane> getAllFlightsUsingJPQL();
	    @Modifying
	    @Transactional
	    @Query(value="update aeroplane set flight_name=?1 where flightid=?2",nativeQuery = true)
	    public int updateinfo(String newtype,int oldid);
	    
}
