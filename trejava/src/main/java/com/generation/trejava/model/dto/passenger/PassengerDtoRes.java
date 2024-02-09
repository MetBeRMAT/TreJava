package com.generation.trejava.model.dto.passenger;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class PassengerDtoRes extends PassengerDtoBase
{
    private Integer id;

    public PassengerDtoRes(){};
}
