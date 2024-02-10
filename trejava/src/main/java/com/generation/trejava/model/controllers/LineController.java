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

import com.generation.trejava.model.dto.line.LineDtoReqPlus;
import com.generation.trejava.model.dto.line.LineDtoRes;
import com.generation.trejava.model.dtoservices.LineConverter;
import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.repositories.LineRepository;

@RestController
@CrossOrigin
public class LineController 
{
    @Autowired
    LineRepository repo;
    @Autowired
    LineConverter conv;

    @GetMapping("/lines")
    public List<LineDtoReqPlus> getAllLines()
    {
        return  repo.findAll().stream().map(l -> conv.linetoDtoFull(l)).toList();
    }

    @PostMapping("/lines")
    public LineDtoReqPlus insert(@RequestBody LineDtoRes dto)
    {
        Line l = conv.dtoResToLine(dto);
        return conv.linetoDtoFull(repo.save(l));
    }

    @PutMapping("/lines")
    public LineDtoReqPlus update(@RequestBody LineDtoRes dto)
    {
        Line l = conv.dtoResToLine(dto);
        return  conv.linetoDtoFull(repo.save(l));
    }

    @PutMapping("/lines/{id}")
    public LineDtoReqPlus update(@RequestBody LineDtoRes dto,@PathVariable Integer id)
    {
        dto.setId(id);
        Line l = conv.dtoResToLine(dto);
        return  conv.linetoDtoFull(repo.save(l));
    }

    @DeleteMapping("/lines/{id}")
    public void delete(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
