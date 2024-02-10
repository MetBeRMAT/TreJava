package com.generation.trejava;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.entities.Passenger;
import com.generation.trejava.model.entities.Ticket;
import com.generation.trejava.model.entities.Train;
import com.generation.trejava.model.repositories.LineRepository;
import com.generation.trejava.model.repositories.PassengerRepository;
import com.generation.trejava.model.repositories.TicketRepository;
import com.generation.trejava.model.repositories.TrainRepository;

@SpringBootTest
class TrejavaApplicationTests 
{
	@Autowired
	TrainRepository tRepo;
	@Autowired
	LineRepository lRepo;
	@Autowired
	PassengerRepository pRepo;
	@Autowired
	TicketRepository ticketRepo;
	
	@Test
	void contextLoads() 
	{
		Train t = 	Train.builder()
					.average_speed(80)
					.type("Regional")
					.capacity(5000)
					.serial_number("5342-6789-54")
					.build();

		tRepo.save(t);

		Line l =	Line.builder()
					.departure_station("Anzio")
					.destination_station("Roma")
					.departure_time(LocalDateTime.of(2024, 02, 10, 16, 20))
					.length(60)
					.train(t)
					.build();

		lRepo.save(l);

		Passenger p =	Passenger.builder()
						.name("Mattia")
						.surname("Bernardi")
						.age(23)
						.build();

		pRepo.save(p);

		Ticket ticket =	Ticket.builder()
						.base_price(15)
						.level("economy")
						.line(l)
						.passenger(p)
						.build();

		ticketRepo.save(ticket);
	}

}
