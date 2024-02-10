package com.generation.trejava.model.dto.train;

import java.util.List;

import com.generation.trejava.model.entities.Line;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDtoReqPlus extends TrainDtoBase
{
    private Integer id;
    private List<Line> lines;
    private int nTotTratte;
    private int nTotKm;
    private int nTotTempo;
    private int averageTrain;
}
