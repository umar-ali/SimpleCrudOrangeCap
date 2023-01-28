package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Vehicle;
import com.example.repository.VehicleRepository;



@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> vehicle = new ArrayList<Vehicle>();
		vehicleRepository.findAll().forEach(vehicle1 -> vehicle.add(vehicle1));
		return vehicle;
	}

	public Vehicle getVehicleById(int id) {
		return vehicleRepository.findById(id).get();
	}

	public void saveOrUpdate(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	public void delete(int id) {
		vehicleRepository.deleteById(id);
	}

	public void update(Vehicle vehicle, int vehicleno) {
		vehicleRepository.save(vehicle);
	}
}
