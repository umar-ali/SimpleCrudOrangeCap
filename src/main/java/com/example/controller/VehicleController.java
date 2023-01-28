package com.example.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Vehicle;
import com.example.service.VehicleService;

//mark class as Controller  
@RestController
public class VehicleController {
//autowire the VehicleService class  
	@Autowired
	VehicleService vehicleService;

//creating a get mapping that retrieves all the vehicles detail from the database   
	@GetMapping("/vehicle")
	private List<Vehicle> getAllVehicle() {
		return vehicleService.getAllVehicle();
	}

//creating a get mapping that retrieves the detail of a specific vehicle  
	@GetMapping("/vehicle/{vehicleid}")
	private Vehicle getVehicle(@PathVariable("vehicleno") int vehicleid) {
		return vehicleService.getVehicleById(vehicleid);
	}

//creating a delete mapping that deletes a specified vehicle  
	@DeleteMapping("/vehicle/{vehicleno}")
	private void deleteVehicle(@PathVariable("vehicleno") int vehicleid) {
		vehicleService.delete(vehicleid);
	}

//creating post mapping that post the vehicle detail in the database  
	@PostMapping("/vehicles")
	private int saveVehicle(@RequestBody Vehicle vehicles) {
		vehicleService.saveOrUpdate(vehicles);
		return vehicles.getVehicleno();
	}

//creating put mapping that updates the vehicle detail   
	@PutMapping("/uvehicles")
	private Vehicle update(@RequestBody Vehicle vehicle) {
		vehicleService.saveOrUpdate(vehicle);
		return vehicle;
	}

//Creating mapping for date format
	

}
