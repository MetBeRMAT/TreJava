package com.generation.trejava.model.dto.line;

import java.time.LocalDateTime;
import java.util.List;

import com.generation.trejava.model.entities.Ticket;
import com.generation.trejava.model.entities.Train;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LineDtoReqPlus extends LineDtoBase
{
    private Integer id;

    private Train train;
    private List<Ticket> tickets;
    private int durationOfLine;
    private LocalDateTime arrival_time;
}

