package com.example.AeroplaneTicket.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;




@Entity
public class Aeroplane {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 
	//attributes
	private int Flightid;
	private String flightName;
	private int flightCapacity;
	private String flightowned;
	private String destination;
	
	

	// one to one mapping
		@OneToOne(cascade = CascadeType.ALL)
		private Passenger passengers;
	

		public Passenger getPassengers() {
			return passengers;
		}
		public void setPassengers(Passenger passengers) {
			this.passengers = passengers;
		}
		//One to Many
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="fk_id")
		private List<Passenger> Passenger;
		
		
	
	public List<Passenger> getPassenger() {
			return Passenger;
		}
		public void setPassenger(List<Passenger> passenger) {
			Passenger = passenger;
		}
		public int getFlightid() {
			return Flightid;
		}
		public void setFlightid(int flightid) {
			Flightid = flightid;
		}
		public String getFlightName() {
			return flightName;
		}
		public void setFlightName(String flightName) {
			this.flightName = flightName;
		}
		public int getFlightCapacity() {
			return flightCapacity;
		}
		public void setFlightCapacity(int flightCapacity) {
			this.flightCapacity = flightCapacity;
		}
		public String getFlightowned() {
			return flightowned;
		}
		public void setFlightowned(String flightowned) {
			this.flightowned = flightowned;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public Aeroplane(int flightid, String flightName, int flightCapacity, String flightowned, String destination,
				com.example.AeroplaneTicket.entity.Passenger passengers,
				List<com.example.AeroplaneTicket.entity.Passenger> passenger) {
			super();
			Flightid = flightid;
			this.flightName = flightName;
			this.flightCapacity = flightCapacity;
			this.flightowned = flightowned;
			this.destination = destination;
			this.passengers = passengers;
			Passenger = passenger;
		}
		public Aeroplane() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	
//	//getters and setters for Passenger
//	public Passenger getpassenger() {
//		return passengers;
//	}
//	public void setPassenger(Passenger passengers) {
//		this.passengers = passengers;
//	}
//	
//	//getters and setters for passengerEntity
//	public List<Passenger> getPassenger() {
//		return Passenger;
//	}
//	public void setPassenger(List<Passenger> Passenger) {
//		this.Passenger = Passenger;
//	}
	
   	
	
}
