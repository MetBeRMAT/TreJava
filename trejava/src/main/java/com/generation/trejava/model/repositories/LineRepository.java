package com.generation.trejava.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.trejava.model.entities.Line;

public interface LineRepository extends JpaRepository<Line,Integer>
{

}
