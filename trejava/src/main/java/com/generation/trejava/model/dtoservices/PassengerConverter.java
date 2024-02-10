package com.generation.trejava.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.passenger.PassengerDtoReqPlus;
import com.generation.trejava.model.dto.passenger.PassengerDtoRes;
import com.generation.trejava.model.entities.Passenger;
import com.generation.trejava.model.entities.Ticket;
import com.generation.trejava.model.repositories.PassengerRepository;

@Service
public class PassengerConverter 
{
    @Autowired
    PassengerRepository repo;

    public Passenger dtoResToPassenger(PassengerDtoRes dto)
    {
        return  Passenger
                .builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .age(dto.getAge())
                .build();
    }

    public PassengerDtoReqPlus PassengerToDtoFull(Passenger p)
    {
        return  PassengerDtoReqPlus
                .builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .age(p.getAge())
                .totalSpending(calcTotalSpending(p))
                .nTicketBuyed(p.getTickets().size())
                .build();
    }

    public int calcTotalSpending(Passenger p)
    {
        if(p.getTickets()==null)
            return 0;
        
        int res = 0;

        for(Ticket t : p.getTickets())
            res+= t.getBase_price();

        return res;
    }

}
