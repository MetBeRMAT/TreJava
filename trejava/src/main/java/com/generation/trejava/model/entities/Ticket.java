package com.generation.trejava.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ticket 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String level;
    private int base_price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passenger_id")
    @JsonIgnore
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "line_id")
    @JsonIgnore
    private Line line;
}
