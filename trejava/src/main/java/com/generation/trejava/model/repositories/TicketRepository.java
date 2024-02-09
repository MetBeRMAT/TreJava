package com.generation.trejava.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.trejava.model.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer>
{

}
