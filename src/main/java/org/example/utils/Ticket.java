package org.example.utils;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;



@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Ticket {

    
    public String origin;
    
    public String originName;
    
    public String destination;
    
    public String destinationName;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    public LocalDate departureDate;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "H:mm")
    public LocalTime departureTime;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    public LocalDate arrivalDate;
    
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "H:mm")
    public LocalTime arrivalTime;
    
    public String carrier;
    
    public Integer stops;
    
    public Integer price;


}


