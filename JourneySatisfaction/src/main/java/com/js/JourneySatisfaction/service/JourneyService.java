package com.js.JourneySatisfaction.service;

import java.util.List;
import java.util.Optional;

import com.js.JourneySatisfaction.model.Journey;

public interface JourneyService {
    List<Journey> getAllJourneys();
    Optional<Journey> getJourneyById(Long id);
    void saveJourney(Journey journey);
}