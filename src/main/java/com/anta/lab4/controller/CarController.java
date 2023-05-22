package com.anta.lab4.controller;

import com.anta.lab4.dto.CarDTO;
import com.anta.lab4.repository.CarRepository;
import com.anta.lab4.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CarController {

	private final CarRepository carRepository;
	private final CarService carService;

	@GetMapping("/cars")
	public String getCars(Model model) {
		model.addAttribute("json", carService.getJsonFromDTO());
		return "cars";
	}

	@PostMapping("/cars/add")
	public String addCar(@RequestBody CarDTO carDTO) {
		carService.addCar(carDTO);
		return "cars";
	}

	@PutMapping("/cars/edit/{id}")
	public String editCar(@PathVariable String id, @RequestBody CarDTO carDTO) {
		carService.editCar(id, carDTO);
		return "cars";
	}

	@DeleteMapping("/cars/{id}")
	public String deleteCar(@PathVariable String id) {
		carRepository.deleteById(Integer.valueOf(id));
		return "cars";
	}
}
