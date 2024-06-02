package com.js.JourneySatisfaction.service;

import java.util.List;
import java.util.Optional;

import com.js.JourneySatisfaction.model.Passenger;

public interface PassengerService {
    List<Passenger> getAllPassengers();
    Optional<Passenger> getPassengerById(Long id);
    void savePassenger(Passenger passenger);
    void deletePassengerById(Long id);
}