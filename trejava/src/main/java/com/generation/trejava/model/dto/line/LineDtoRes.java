package com.generation.trejava.model.dto.line;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class LineDtoRes extends LineDtoBase
{
    public LineDtoRes(){}
    public Integer id;
    private Integer train_id;
}
