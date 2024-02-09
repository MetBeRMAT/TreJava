package com.generation.trejava.model.dto.passenger;

import java.util.List;

import com.generation.trejava.model.entities.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDtoReqPlus extends PassengerDtoBase
{  
    private Integer id;
    private List<Ticket> tickets;
    private int nTicketBuyed;
    private int totalSpending;
}
