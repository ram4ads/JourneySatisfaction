package com.js.JourneySatisfaction.thymeleaf.controller1;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.js.JourneySatisfaction.model.Bus;
import com.js.JourneySatisfaction.model.Journey;
import com.js.JourneySatisfaction.model.Passenger;
import com.js.JourneySatisfaction.model.Rating;
import com.js.JourneySatisfaction.service.BusService;
import com.js.JourneySatisfaction.service.JourneyService;
import com.js.JourneySatisfaction.service.PassengerService;

@Controller
@RequestMapping("/journeys")
public class JourneyThymeleafController2 {

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private BusService busService;

    @Autowired
    private PassengerService passengerService;

    // Show booking form
    @GetMapping("/book")
    public String showBookingForm(Model model) {
        model.addAttribute("passenger", new Passenger());
        model.addAttribute("buses", busService.getAllBuses());
        return "journey/book-journey";
    }

    // Handle booking form submission
//    @PostMapping("/book")
//    public String bookJourney(@ModelAttribute Passenger passenger, @ModelAttribute Journey journey, @RequestParam String serviceProvider, @RequestParam String serviceNumber, @RequestParam String registrationNumber) {
//        Bus bus = busService.getBusByProviderServiceRegistration(serviceProvider, serviceNumber, registrationNumber).orElse(null);
//        journey.setPassenger(passenger);
//        journey.setBus(bus);
//        journeyService.saveJourney(journey);
//        return "redirect:/journeys";
//    }
    
    @PostMapping("/book")
    public String bookJourney(@RequestParam("busId") Long busId,
                              @RequestParam("passengerName") String passengerName,
                              @RequestParam("passengerEmail") String passengerEmail,
                              @RequestParam("passengerPhoneNumber") String passengerPhoneNumber,
                              @RequestParam("dateOfJourney") String dateOfJourney) {

        // Retrieve the selected bus
        Optional<Bus> bus = busService.getBusById(busId);
        
        
        
        // Create a new Passenger object
        Passenger passenger = new Passenger();
        passenger.setName(passengerName);
        passenger.setEmail(passengerEmail);
        passenger.setPhoneNumber(passengerPhoneNumber);
        passengerService.savePassenger(passenger);
        // Create a new Journey object
        Journey journey = new Journey();
        journey.setPassenger(passenger);
        journey.setBus(bus.get());
        journey.setDateOfJourney(LocalDate.parse(dateOfJourney));

        // Save the journey
        journeyService.saveJourney(journey);

        // Redirect to a success page or wherever appropriate
        return "redirect:/journeys";
    }

    // Show rating form
    @GetMapping("/rate/{id}")
    public String showRatingForm(@PathVariable Long id, Model model) {
        Journey journey = journeyService.getJourneyById(id).orElse(null);
        model.addAttribute("journey", journey);
        return "journey/rate-journey";
    }

    // Handle rating form submission
    @PostMapping("/rate/{id}")
    public String rateJourney(@PathVariable Long id,
    		@RequestParam("seatQuality") int seatQualtiy,
    		@RequestParam("safeDriving") int  safeDriving,
    		@RequestParam("amenities") int  amenities,
    		@RequestParam("restRoomStops") int  restRoomStops,
    		@RequestParam("luggageSafety") int  luggageSafety) {
    	
    	Rating rating = new Rating();
    	rating.setAmenities(amenities);
    	rating.setLuggageSafety(luggageSafety);
    	rating.setRestRoomStops(restRoomStops);
    	rating.setSafeDriving(safeDriving);
    	rating.setSeatQuality(seatQualtiy);
    	
        Journey journey = journeyService.getJourneyById(id).orElseThrow(() -> new IllegalArgumentException("Invalid journey ID: " + id));
        journey.setRating(rating);
        System.out.println(journey.toString());
        journeyService.saveJourney(journey);
        return "redirect:/journeys";
    }

    // List all journeys
    @GetMapping
    public String listJourneys(Model model) {
        model.addAttribute("journeys", journeyService.getAllJourneys());
        return "journey/journey-list";
    }
}
