package com.generation.trejava.model.dto.line;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LineDtoBase 
{
    private String departure_station, destination_station;
    private int length;
    private LocalDateTime departure_time;
}
