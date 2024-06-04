package com.js.JourneySatisfaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.JourneySatisfaction.model.Bus;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {
	Optional<Bus> findByServiceProviderAndServiceNumberAndRegistrationNumber(String serviceProvider,
			String serviceNumber, String registrationNumber);
	Optional<Bus> findTopByOrderByIdDesc();
	
}
