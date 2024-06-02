package com.js.JourneySatisfaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.js.JourneySatisfaction.model.Journey;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {
}