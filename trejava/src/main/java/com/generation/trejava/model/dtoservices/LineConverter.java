package com.generation.trejava.model.dtoservices;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.line.LineDtoReqPlus;
import com.generation.trejava.model.dto.line.LineDtoRes;
import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.repositories.TrainRepository;

@Service
public class LineConverter 
{
    @Autowired(required = true)
    TrainRepository repo;

    public Line dtoResToLine(LineDtoRes dto)
    {
        return  Line
                .builder()
                .id(dto.getId())
                .train(repo.findById(dto.getTrain_id()).get())
                .departure_station(dto.getDeparture_station())
                .departure_time(dto.getDeparture_time())
                .length(dto.getLength())
                .destination_station(dto.getDestination_station())
                .build();
    }

    public LineDtoReqPlus linetoDtoFull(Line l)
    {
        return  LineDtoReqPlus
                .builder()
                .train(repo.findById(l.getTrain().getId()).get())
                .departure_station(l.getDeparture_station())
                .departure_time(l.getDeparture_time())
                .length(l.getLength())
                .destination_station(l.getDestination_station())
                .id(l.getId())
                .tickets(l.getTickets())
                .durationOfLine(calcDurationOfLine(l))
                .arrival_time(calcArrivalTime(l))
                .build();
    }

    public int calcDurationOfLine(Line l)
    {
        if(l.getTrain()==null || l.getTrain().getAverage_speed() == 0)
            return 0;

        return l.getLength()/l.getTrain().getAverage_speed()*60;
    }

    public LocalDateTime calcArrivalTime(Line l)
    {
        if (l.getDeparture_time() == null || l.getTrain() == null || l.getTrain().getAverage_speed() == 0)
            return null;

        return l.getDeparture_time().plusMinutes(calcDurationOfLine(l));
    }
}

