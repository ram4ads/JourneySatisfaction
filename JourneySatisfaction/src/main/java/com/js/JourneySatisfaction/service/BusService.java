package com.js.JourneySatisfaction.service;

import java.util.List;
import java.util.Optional;

import com.js.JourneySatisfaction.model.Bus;

public interface BusService {
    List<Bus> getAllBuses();
    Optional<Bus> getBusById(Long id);
    Optional<Bus> getBusByProviderServiceRegistration(String serviceProvider, String serviceNumber, String registrationNumber);
    Bus createBus(Bus bus);
    Optional<Bus> updateBus(String serviceProvider, String serviceNumber, String registrationNumber, Bus bus);
    boolean deleteBus(String serviceProvider, String serviceNumber, String registrationNumber);
    Optional<Bus> findLatestEntity();
}
