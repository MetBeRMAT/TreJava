package com.generation.trejava.model.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Line 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String departure_station, destination_station;
    private int length;
    private LocalDateTime departure_time;

    @JsonIgnore
    @JoinColumn(name = "train_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Train train;

    @JsonIgnore
    @OneToMany(mappedBy = "line",fetch = FetchType.EAGER)
    private List<Ticket> tickets;
}
