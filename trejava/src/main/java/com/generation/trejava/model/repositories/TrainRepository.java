package com.generation.trejava.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.trejava.model.entities.Train;

public interface TrainRepository extends JpaRepository<Train,Integer>
{

}
