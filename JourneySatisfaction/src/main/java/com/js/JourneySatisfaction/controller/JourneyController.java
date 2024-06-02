package com.js.JourneySatisfaction.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.js.JourneySatisfaction.model.Bus;
import com.js.JourneySatisfaction.model.Journey;
import com.js.JourneySatisfaction.model.Passenger;
import com.js.JourneySatisfaction.model.Rating;
import com.js.JourneySatisfaction.service.BusService;
import com.js.JourneySatisfaction.service.JourneyService;
import com.js.JourneySatisfaction.service.PassengerService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/journeys1")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private BusService busService;

    @GetMapping
    public String listJourneys(Model model) {
        List<Journey> journeys = journeyService.getAllJourneys();
        model.addAttribute("journeys", journeys);
        return "journey/journey-list";
    }

    @GetMapping("/book")
    public String showBookJourneyForm(Model model) {
        List<Bus> buses = busService.getAllBuses();
        model.addAttribute("buses", buses);
        model.addAttribute("passenger", new Passenger());
        return "journey/book-journey";
    }

    @PostMapping("/book")
    public String bookJourney(@RequestParam Long busId, @ModelAttribute Passenger passenger) {
        Bus bus = busService.getBusById(busId).orElseThrow(() -> new IllegalArgumentException("Invalid bus ID: " + busId));
        passengerService.savePassenger(passenger);
        Journey journey = new Journey();
        journey.setPassenger(passenger);
        journey.setBus(bus);
        journeyService.saveJourney(journey);
        return "redirect:/journeys";
    }

    @GetMapping("/rate/{id}")
    public String showRateJourneyForm(@PathVariable Long id, Model model) {
        Journey journey = journeyService.getJourneyById(id).orElseThrow(() -> new IllegalArgumentException("Invalid journey ID: " + id));
        model.addAttribute("journey", journey);
        model.addAttribute("rating", new Rating());
        return "rate-journey";
    }

    @PostMapping("/rate/{id}")
    public String rateJourney(@PathVariable Long id, @ModelAttribute Rating rating) {
        Journey journey = journeyService.getJourneyById(id).orElseThrow(() -> new IllegalArgumentException("Invalid journey ID: " + id));
        journey.setRating(rating);
        journeyService.saveJourney(journey);
        return "redirect:/journeys";
    }
}
