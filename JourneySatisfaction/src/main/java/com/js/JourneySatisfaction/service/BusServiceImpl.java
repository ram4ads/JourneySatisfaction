package com.js.JourneySatisfaction.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.JourneySatisfaction.model.Bus;
import com.js.JourneySatisfaction.repository.BusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Optional<Bus> getBusByProviderServiceRegistration(String serviceProvider, String serviceNumber, String registrationNumber) {
        return busRepository.findByServiceProviderAndServiceNumberAndRegistrationNumber(serviceProvider, serviceNumber, registrationNumber);
    }

    @Override
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Optional<Bus> updateBus(String serviceProvider, String serviceNumber, String registrationNumber, Bus bus) {
        return busRepository.findByServiceProviderAndServiceNumberAndRegistrationNumber(serviceProvider, serviceNumber, registrationNumber)
                .map(existingBus -> {
                    existingBus.setServiceProvider(bus.getServiceProvider());
                    existingBus.setServiceNumber(bus.getServiceNumber());
                    existingBus.setRegistrationNumber(bus.getRegistrationNumber());
                    existingBus.setOrigin(bus.getOrigin());
                    existingBus.setDestination(bus.getDestination());
                    existingBus.setCapacity(bus.getCapacity());
                    System.out.println("-------------------------");
                    System.out.println(existingBus);
                    return busRepository.save(existingBus);
                });
    }

    @Override
    public boolean deleteBus(String serviceProvider, String serviceNumber, String registrationNumber) {
        return busRepository.findByServiceProviderAndServiceNumberAndRegistrationNumber(serviceProvider, serviceNumber, registrationNumber)
                .map(bus -> {
                    busRepository.delete(bus);
                    return true;
                }).orElse(false);
    }

	@Override
	public Optional<Bus> getBusById(Long id) {
		// TODO Auto-generated method stub
		return busRepository.findById(id);
	}
	
	@Override
    public Optional<Bus> findLatestEntity() {
        return busRepository.findTopByOrderByIdDesc();
    }
}
