package com.example.AeroplaneTicket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AeroplaneTicket.entity.Aeroplane;
import com.example.AeroplaneTicket.service.AeroplaneService;
@RestController
@RequestMapping("/Aeroplane")
public class AeroplaneController {
	
	Logger logger = LoggerFactory.getLogger(AeroplaneController.class);
	@Autowired
	private AeroplaneService flightService;
	

	@PostMapping(path="/saveflight")
	public Aeroplane saveFlights(@RequestBody Aeroplane f) {
		return flightService.saveFlights(f);
	}

	@GetMapping(path="/getpage")
	public ResponseEntity<Page<Aeroplane>> getFlightsByField(@RequestParam String field,@RequestParam int pageNo,@RequestParam int pageSize){
		Page<Aeroplane> flights=flightService.getFlightsByField(field, pageNo, pageSize);
		return ResponseEntity.ok(flights);
	}
@GetMapping("/{flightId}")
	public ResponseEntity<Aeroplane> getFlight(@PathVariable int id)
	{
		Aeroplane flight = flightService.getFlight(id);
		if (flight == null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(flight);
	}
	
	
	@PostMapping(path="/post")
	public ResponseEntity<Integer> addFlight(@RequestBody Aeroplane f) {
		int id = flightService.addFlight(f);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	}
	
	
	@GetMapping(path="/get/{Flightid}")
	public ResponseEntity<List<Aeroplane>> getAllFlights(){
		List<Aeroplane> flight = flightService.getAllFlights();
		return ResponseEntity.status(HttpStatus.OK).body(flight);
	}
	
	
	@PutMapping(path="/put")
	public ResponseEntity<String> updateBook(@RequestBody Aeroplane f) {
		flightService.updateFlight(f);
		return ResponseEntity.ok("Updated");
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteFlight(@RequestBody Aeroplane f) {
		flightService.deleteFlight(f.getFlightid());
		return ResponseEntity.ok("Deleted");
	}
	
	@DeleteMapping("del/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		flightService.deleteById(id);
		return ResponseEntity.ok("Deleted by id");

	}
	
	
	@GetMapping("/getFlightsUsingJPQL")
	public List<Aeroplane> getAllFlightsUsingJPQL(){
		return flightService.getAllFlightsUsingJPQL();
	}
    @PutMapping("update/{newtype}/{old}")
    public String updateinfo(@PathVariable String newtype,@PathVariable int old) {
    	flightService.upadteinfo(newtype , old);
    	return "updated";
    }
    @GetMapping(path="/loggerdemo")
	public String loggerDemo() {
		logger.info("Logger info");
		logger.warn("Logger warn");
		logger.error("logger error");
		return "Hello from logger demo";
	}
    
    
}
