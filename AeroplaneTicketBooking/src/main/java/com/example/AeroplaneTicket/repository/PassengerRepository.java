package com.example.AeroplaneTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AeroplaneTicket.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Integer>{

}
