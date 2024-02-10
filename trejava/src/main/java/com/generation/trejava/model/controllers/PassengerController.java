package com.generation.trejava.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.trejava.model.dto.passenger.PassengerDtoReqPlus;
import com.generation.trejava.model.dto.passenger.PassengerDtoRes;
import com.generation.trejava.model.dtoservices.PassengerConverter;
import com.generation.trejava.model.entities.Passenger;
import com.generation.trejava.model.repositories.PassengerRepository;

@RestController
@CrossOrigin
public class PassengerController 
{
    @Autowired
    PassengerRepository repo;
    @Autowired
    PassengerConverter conv;

    @GetMapping("/passengers")
    public List<PassengerDtoReqPlus> getAllPassengers()
    {
        return  repo.findAll().stream().map(p -> conv.PassengerToDtoFull(p)).toList();
    }

    @PostMapping("/passengers")
    public PassengerDtoReqPlus insert(@RequestBody PassengerDtoRes dto)
    {
        Passenger p = conv.dtoResToPassenger(dto);
        return conv.PassengerToDtoFull(repo.save(p));
    }

    @PutMapping("/passengers")
    public PassengerDtoReqPlus update(@RequestBody PassengerDtoRes dto)
    {
        Passenger p = conv.dtoResToPassenger(dto);
        return  conv.PassengerToDtoFull(repo.save(p));
    }

    @PutMapping("/passengers/{id}")
    public PassengerDtoReqPlus update(@RequestBody PassengerDtoRes dto,@PathVariable Integer id)
    {
        dto.setId(id);
        Passenger p = conv.dtoResToPassenger(dto);
        return  conv.PassengerToDtoFull(repo.save(p));
    }

    @DeleteMapping("/passengers/{id}")
    public void delete(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
