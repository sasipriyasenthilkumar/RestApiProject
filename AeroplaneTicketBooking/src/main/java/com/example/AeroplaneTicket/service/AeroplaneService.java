package com.example.AeroplaneTicket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.AeroplaneTicket.entity.Aeroplane;
import com.example.AeroplaneTicket.repository.AeroplaneRepository;


@Service
public class AeroplaneService {
	@Autowired
	private AeroplaneRepository flightRepository;
	
	public Aeroplane saveFlights(Aeroplane f) {
		return flightRepository.save(f);
	}
	
	
	
	public Page<Aeroplane> getFlightsByField(String field,int pageNo,int pageSize){
		Sort sort=Sort.by(field);
		Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
		return flightRepository.findAll(pageable);
	}
	
	
	
	
	public Aeroplane getFlight(int Flightid) {
		Optional<Aeroplane> optional=flightRepository.findById(Flightid);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public int addFlight(Aeroplane f){
		Aeroplane save=flightRepository.save(f);
		return save.getFlightid();
		}
	
	public List<Aeroplane> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public void updateFlight(Aeroplane f) {
		flightRepository.save(f);
		
	}
	
	public void deleteFlight(int id) {
		Optional<Aeroplane> optional = flightRepository.findById(id);
		if(!optional.isEmpty()) {
		  flightRepository.delete(optional.get());
		}
	}



	public void deleteById(int id) {
	// TODO Auto-generated method stub
		Optional<Aeroplane>optional=flightRepository.findById(id);
		if(!optional.isEmpty()) {
			  flightRepository.delete(optional.get());
			}
		
	}

	public List<Aeroplane> getAllFlightsUsingJPQL(){
		return flightRepository.getAllFlightsUsingJPQL();
	}



	public String upadteinfo(String newtype, int old) {
		// TODO Auto-generated method stub
		flightRepository.updateinfo(newtype,old);
     return "updated";
	}


}
