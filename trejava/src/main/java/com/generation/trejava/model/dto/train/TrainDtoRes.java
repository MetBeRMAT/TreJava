package com.generation.trejava.model.dto.train;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TrainDtoRes extends TrainDtoBase
{
    public TrainDtoRes(){};
    private Integer id;
}
