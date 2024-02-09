package com.generation.trejava.model.dto.ticket;

import com.generation.trejava.model.dto.line.LineDtoReqPlus;
import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.entities.Passenger;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TicketDtoReqPlus extends TicketDtoBase
{
    private Integer id;
    private Passenger passenger;
    private Line line;
    private LineDtoReqPlus lineDtoReqPlus;
    private double price;
    private String passengerName,passengerSurname;
}
