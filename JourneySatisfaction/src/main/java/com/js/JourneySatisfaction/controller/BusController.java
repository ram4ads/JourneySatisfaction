package com.js.JourneySatisfaction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.js.JourneySatisfaction.model.Bus;
import com.js.JourneySatisfaction.service.BusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buses1")
public class BusController {

    @Autowired
    private BusService busService;

    // Retrieve all buses
    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    // Retrieve a specific bus by service provider, service number, and registration number
    @GetMapping("/{serviceProvider}/{serviceNumber}/{registrationNumber}")
    public ResponseEntity<Bus> getBusById(
            @PathVariable String serviceProvider,
            @PathVariable String serviceNumber,
            @PathVariable String registrationNumber) {
        Optional<Bus> bus = busService.getBusByProviderServiceRegistration(serviceProvider, serviceNumber, registrationNumber);
        return bus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new bus
    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus createdBus = busService.createBus(bus);
        return ResponseEntity.ok(createdBus);
    }

    // Update an existing bus
    @PutMapping("/{serviceProvider}/{serviceNumber}/{registrationNumber}")
    public ResponseEntity<Bus> updateBus(
            @PathVariable String serviceProvider,
            @PathVariable String serviceNumber,
            @PathVariable String registrationNumber,
            @RequestBody Bus bus) {
        Optional<Bus> updatedBus = busService.updateBus(serviceProvider, serviceNumber, registrationNumber, bus);
        return updatedBus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a bus
    @DeleteMapping("/{serviceProvider}/{serviceNumber}/{registrationNumber}")
    public ResponseEntity<Void> deleteBus(
            @PathVariable String serviceProvider,
            @PathVariable String serviceNumber,
            @PathVariable String registrationNumber) {
        boolean isDeleted = busService.deleteBus(serviceProvider, serviceNumber, registrationNumber);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

