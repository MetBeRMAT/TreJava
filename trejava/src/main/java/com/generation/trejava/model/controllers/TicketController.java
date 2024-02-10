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

import com.generation.trejava.model.dto.ticket.TicketDtoReqPlus;
import com.generation.trejava.model.dto.ticket.TicketDtoRes;
import com.generation.trejava.model.dtoservices.TicketConverter;
import com.generation.trejava.model.entities.Ticket;
import com.generation.trejava.model.repositories.TicketRepository;

@RestController
@CrossOrigin
public class TicketController 
{
    @Autowired
    TicketRepository repo;
    @Autowired
    TicketConverter conv;

    @GetMapping("/tickets")
    public List<TicketDtoReqPlus> getAllTickets()
    {
        return  repo.findAll().stream().map(t -> conv.ticketToDtoFull(t)).toList();
    }

    @PostMapping("/tickets")
    public TicketDtoReqPlus insert(@RequestBody TicketDtoRes dto)
    {
        Ticket t = conv.dtoResToTicket(dto);
        return conv.ticketToDtoFull(repo.save(t));
    }

    @PutMapping("/tickets")
    public TicketDtoReqPlus update(@RequestBody TicketDtoRes dto)
    {
        Ticket t = conv.dtoResToTicket(dto);
        return  conv.ticketToDtoFull(repo.save(t));
    }

    @PutMapping("/tickets/{id}")
    public TicketDtoReqPlus update(@RequestBody TicketDtoRes dto,@PathVariable Integer id)
    {
        dto.setId(id);
        Ticket p = conv.dtoResToTicket(dto);
        return  conv.ticketToDtoFull(repo.save(p));
    }

    @DeleteMapping("/tickets/{id}")
    public void delete(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
