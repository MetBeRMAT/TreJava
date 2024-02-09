package com.generation.trejava.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.trejava.model.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Integer>
{

}
