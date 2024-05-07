package org.example;

import org.example.utils.Ticket;
import org.example.utils.TicketList;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class FlightCalculator {

    private Map<String, Integer> minFlightDurationMap = new HashMap<>();

    private int calculateFlightDuration(Ticket flight) {
        return (int) Duration.between(flight.departureDate.atTime(flight.departureTime), flight.arrivalDate.atTime(flight.arrivalTime)).toMinutes();
    }

    private void printMinFlightDuration(TicketList tickets) {
        List<Ticket> flights = Arrays.stream(tickets.getTickets()).collect(Collectors.toList());

        flights.forEach(this::processFlight); 

        System.out.println("Flight duration differences:");
        minFlightDurationMap.entrySet().forEach(el -> {
            System.out.println(el.getKey() + " " + el.getValue());
        });
    }

    private void processFlight(Ticket flight) {
        if (flight.origin.equals("VVO") && flight.destination.equals("TLV")) {
            if (!minFlightDurationMap.containsKey(flight.carrier)) {
                minFlightDurationMap.put(flight.carrier, calculateFlightDuration(flight));
            } else {
                minFlightDurationMap.put(flight.carrier, Math.min(minFlightDurationMap.get(flight.carrier), calculateFlightDuration(flight)));
            }
        }
    }

    private void printDifferenceBetweenMedianAndAverage(TicketList tickets) {
        int sum = 0;
        List<Integer> prices = new ArrayList<>();

        for (Ticket flight : tickets.getTickets()) {
            if (flight.origin.equals("VVO") && flight.destination.equals("TLV")) {
                prices.add(flight.price);
            }
        }

        prices.sort(Comparator.naturalOrder());
        sum = prices.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Difference between median and mean:");
        if (prices.size() % 2 == 0) {
            System.out.println(Math.abs(sum / prices.size() - ((prices.get(prices.size() / 2 - 1) + prices.get(prices.size() / 2)) / 2)));
        } else {
            System.out.println(Math.abs(sum / prices.size() - prices.get(prices.size() / 2 + 1)));
        }
    }

    public void doTask(TicketList tickets){
        printMinFlightDuration(tickets);
        printDifferenceBetweenMedianAndAverage(tickets);
    }
}
