package com.js.JourneySatisfaction.thymeleaf.controller;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.js.JourneySatisfaction.model.Bus;
import com.js.JourneySatisfaction.service.BusService;

import java.util.List;

@Controller
@RequestMapping("/buses")
public class BusThymeleafController {

    @Autowired
    private BusService busService;

    // Retrieve all buses
    @GetMapping
    public String getAllBuses(Model model) {
        List<Bus> buses = busService.getAllBuses();
        model.addAttribute("buses", buses);
        return "bus/bus-list";
    }

    // Retrieve a specific bus by service provider, service number, and registration number
    @GetMapping("/{serviceProvider}/{serviceNumber}/{registrationNumber}")
    public String getBusById(
            @PathVariable String serviceProvider,
            @PathVariable String serviceNumber,
            @PathVariable String registrationNumber,
            Model model) {
        Bus bus = busService.getBusByProviderServiceRegistration(serviceProvider, serviceNumber, registrationNumber)
                            .orElse(null);
        model.addAttribute("bus", bus);
        return "bus/bus-details";
    }

    // Show form to add a new bus
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus/create-bus";
    }

    // Add a new bus
    @PostMapping
    public String createBus(@ModelAttribute com.js.JourneySatisfaction.model.Bus bus) {
        busService.createBus(bus);
        return "redirect:/buses";
    }

    // Show form to update an existing bus
    @GetMapping("/edit/{serviceProvider}/{serviceNumber}/{registrationNumber}")
    public String showEditForm(
            @PathVariable String serviceProvider,
            @PathVariable String serviceNumber,
            @PathVariable String registrationNumber,
            Model model) {
        Bus bus = busService.getBusByProviderServiceRegistration(serviceProvider, serviceNumber, registrationNumber)
                            .orElse(null);
        model.addAttribute("bus", bus);
        return "bus/edit-bus";
    }

    // Update an existing bus
    @PostMapping("/edit/{serviceProvider}/{serviceNumber}/{registrationNumber}")
    public String updateBus(
            @PathVariable String serviceProvider,
            @PathVariable String serviceNumber,
            @PathVariable String registrationNumber,
            @ModelAttribute Bus bus) {
        busService.updateBus(serviceProvider, serviceNumber, registrationNumber, bus);
        return "redirect:/buses";
    }

    // Delete a bus
    @PostMapping("/{serviceProvider}/{serviceNumber}/{registrationNumber}")
    public String deleteBus(
            @PathVariable String serviceProvider,
            @PathVariable String serviceNumber,
            @PathVariable String registrationNumber) {
        busService.deleteBus(serviceProvider, serviceNumber, registrationNumber);
        return "redirect:/buses";
    }
}



