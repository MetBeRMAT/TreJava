package com.generation.trejava.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.line.LineDtoReqPlus;
import com.generation.trejava.model.dto.ticket.TicketDtoReqPlus;
import com.generation.trejava.model.dto.ticket.TicketDtoRes;
import com.generation.trejava.model.entities.Ticket;
import com.generation.trejava.model.repositories.LineRepository;
import com.generation.trejava.model.repositories.PassengerRepository;

@Service
public class TicketConverter 
{
    @Autowired
    PassengerRepository pRepo;
    @Autowired
    LineRepository lRepo;
    @Autowired
    LineConverter lConv;

    public Ticket dtoResToTicket(TicketDtoRes dto)
    {
        return  Ticket
                .builder()
                .level(dto.getLevel())
                .base_price(dto.getBase_price())
                .passenger(pRepo.findById(dto.getPassenger_id()).get())
                .line(lRepo.findById(dto.getLine_id()).get())
                .build();
    }

    public TicketDtoReqPlus ticketToDtoFull(Ticket t)
    {
        LineDtoReqPlus lineFull = lConv.linetoDtoFull(t.getLine());

        return  TicketDtoReqPlus
                .builder()
                .id(t.getId())
                .level(t.getLevel())
                .base_price(t.getBase_price())
                .passenger(pRepo.findById(t.getPassenger().getId()).get())
                .line(lRepo.findById(t.getLine().getId()).get())
                .lineDtoReqPlus(lineFull)
                .price(priceForPassenger(t))
                .passengerName(t.getPassenger().getName())
                .passengerSurname(t.getPassenger().getSurname())
                .build();

    }

    public double priceForPassenger(Ticket t)
    {
        //paga 10 sconto del 20
        //prezzo pieno - (prezzo*sconto/100)
        if(t.getPassenger().getAge()<14)
            return t.getBase_price()-(t.getBase_price()*20/100);

        if(t.getPassenger().getAge()>65)
            return t.getBase_price()-(t.getBase_price()*40/100);

        return t.getBase_price();
    }
}
