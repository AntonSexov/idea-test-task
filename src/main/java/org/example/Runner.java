package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

import org.example.utils.TicketList;


public class Runner {
    void run() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TicketList tickets= objectMapper.readValue(Main.class.getClassLoader().getResourceAsStream("tickets.json"), TicketList.class);
        FlightCalculator calc= new FlightCalculator();
        calc.doTask(tickets);
    }
}
