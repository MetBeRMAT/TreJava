package com.generation.trejava.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.trejava.model.dto.train.TrainDtoReqPlus;
import com.generation.trejava.model.dto.train.TrainDtoRes;
import com.generation.trejava.model.entities.Line;
import com.generation.trejava.model.entities.Train;

@Service
public class TrainConverter 
{
    @Autowired
    LineConverter lConv;
    @Autowired
    TicketConverter tConv;

    public Train dtoToTrain(TrainDtoRes dto)
    {
        return  Train
                .builder()
                .id(dto.getId())
                .serial_number(dto.getSerial_number())
                .type(dto.getType())
                .average_speed(dto.getAverage_speed())
                .capacity(dto.getCapacity())
                .build();
    }

    public TrainDtoReqPlus TrainToDtoFull (Train t)
    {

        return  TrainDtoReqPlus
                .builder()
                .id(t.getId())
                .serial_number(t.getSerial_number())
                .type(t.getType())
                .average_speed(t.getAverage_speed())
                .capacity(t.getCapacity())
                .lines(t.getLines())
                .nTotTratte(t.getLines().size())
                .nTotKm(calcNtotKm(t))
                .nTotTempo(calcNTotTempo(t))
                .averageTrain(calcMediaRiempimento(t))
                .build();
    }

    private int calcNTotTempo(Train t) 
    {
        if(t.getLines()==null)
            return 0;

        int res = 0;

        for(Line l : t.getLines())
            res += lConv.calcDurationOfLine(l);

        return res;
    }

    public int calcNtotKm(Train t)
    {
        if(t.getLines()==null)
            return 0;

        int res = 0;

        for(Line l : t.getLines())
            res += l.getLength();

        return res;
    }

    public int calcMediaRiempimento(Train t)
    {
        //ho 30 persone in un vagone di massimo 50
        //di capienza
        //passegeri * 100 / capacità treno
        //calcolo 30*100/50=3000/50=60%
        int totalPassenger = 0;
        for(Line l : t.getLines())
            totalPassenger += l.getTickets().size();

        return totalPassenger*100/t.getCapacity();
    }
}
