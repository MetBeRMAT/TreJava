package com.generation.trejava.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.trejava.model.dto.ticket.TicketDtoRes;
import com.generation.trejava.model.dto.train.TrainDtoReqPlus;
import com.generation.trejava.model.dto.train.TrainDtoRes;
import com.generation.trejava.model.entities.Ticket;
import com.generation.trejava.model.entities.Train;
import com.generation.trejava.model.repositories.PassengerRepository;

public class TrainConverter 
{
    @Autowired
    LineConverter lConv;
    public Train dtoToTrain(TrainDtoRes dto)
    {
        return  Train
                .builder()
                .id(dto.getId())
                .serial_number(dto.getSerial_number())
                .type(dto.getType())
                .average_speed(dto.getAverage_speed())
                .capacity(dto.getCapacity())
                .build();
    }

    public TrainDtoReqPlus TrainToDtoFull (Train t)
    {

        return  TrainDtoReqPlus
                .builder()
                .id(t.getId())
                .serial_number(t.getSerial_number())
                .type(t.getType())
                .average_speed(t.getAverage_speed())
                .capacity(t.getCapacity())
                .lines(t.getLines())
                .nTotTratte(t.getLines().size())
                .nTotKm()
                .build();
    }
}
