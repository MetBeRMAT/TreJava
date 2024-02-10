package com.generation.trejava.model.dto.train;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDtoBase 
{
    private String serial_number;
    private String type;
    private int average_speed, capacity;
}
