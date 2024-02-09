package com.generation.trejava.model.dto.passenger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PassengerDtoBase 
{
    private String name,surname;
    private Integer age;
}
