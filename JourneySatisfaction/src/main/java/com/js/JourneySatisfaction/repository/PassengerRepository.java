package com.js.JourneySatisfaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.js.JourneySatisfaction.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}