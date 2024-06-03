package com.js.JourneySatisfaction.model;

import java.time.LocalDate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Journey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "passenger_id", nullable = false)
	private Passenger passenger;

	@ManyToOne
	@JoinColumn(name = "bus_id", nullable = false)
	private Bus bus;

	@Embedded
	@Nullable
	private Rating rating;

	private LocalDate dateOfJourney;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	@Override
	public String toString() {
		return "Journey [id=" + id + ", passenger=" + passenger + ", bus=" + bus + ", rating=" + rating
				+ ", dateOfJourney=" + dateOfJourney + "]";
	}
	
}