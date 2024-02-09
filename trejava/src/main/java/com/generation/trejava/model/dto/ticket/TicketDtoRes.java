package com.generation.trejava.model.dto.ticket;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TicketDtoRes extends TicketDtoBase
{
    public TicketDtoRes(){};
    private Integer id;
    private int passenger_id;
    private int line_id;
}
