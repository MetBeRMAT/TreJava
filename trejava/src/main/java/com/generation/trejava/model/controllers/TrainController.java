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

import com.generation.trejava.model.dto.train.TrainDtoReqPlus;
import com.generation.trejava.model.dto.train.TrainDtoRes;
import com.generation.trejava.model.dtoservices.TrainConverter;
import com.generation.trejava.model.entities.Train;
import com.generation.trejava.model.repositories.TrainRepository;

@RestController
@CrossOrigin
public class TrainController 
{
    @Autowired
    TrainRepository repo;
    @Autowired
    TrainConverter conv;

    @GetMapping("/trains")
    public List<TrainDtoReqPlus> getAllTrains()
    {
        return  repo.findAll().stream().map(t -> conv.TrainToDtoFull(t)).toList();
    }

    @PostMapping("/trains")
    public TrainDtoReqPlus insert(@RequestBody TrainDtoRes dto)
    {
        Train t = conv.dtoToTrain(dto);
        return conv.TrainToDtoFull(repo.save(t));
    }

    @PutMapping("/trains")
    public TrainDtoReqPlus update(@RequestBody TrainDtoRes dto)
    {
        Train t = conv.dtoToTrain(dto);
        return  conv.TrainToDtoFull(repo.save(t));
    }

    @PutMapping("/trains/{id}")
    public TrainDtoReqPlus update(@RequestBody TrainDtoRes dto,@PathVariable Integer id)
    {
        dto.setId(id);
        Train t = conv.dtoToTrain(dto);
        return  conv.TrainToDtoFull(repo.save(t));
    }

    @DeleteMapping("/trains/{id}")
    public void delete(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
