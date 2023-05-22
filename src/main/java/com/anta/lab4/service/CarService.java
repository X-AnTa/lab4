package com.anta.lab4.service;


import com.anta.lab4.dto.CarDTO;
import com.anta.lab4.entity.Car;
import com.anta.lab4.mapper.CarMapper;
import com.anta.lab4.repository.CarRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

	private final CarRepository carRepository;
	private final CarMapper carMapper;


	public void addCar(CarDTO carDTO) {
		Car car = carMapper.mapToCar(carDTO);
		carRepository.save(car);
	}

	public void editCar(String id, CarDTO carDTO) {
		Car car = carRepository.getReferenceById(Integer.valueOf(id));
		fromCarDTOToCar(carDTO, car);
		carRepository.save(car);
	}


	public String getJsonFromDTO() {
		List<Car> cars = carRepository.findAll();
		List<CarDTO> carDTOS = new ArrayList<>();
		Gson gson = new Gson();
		for (Car car : cars) {
			carDTOS.add(carMapper.mapToCarDTO(car));
		}
		System.out.println(cars);
		System.out.println(carDTOS);

		return gson.toJson(carDTOS);
	}

	public void fromCarDTOToCar(CarDTO carDTO, Car car) {
		car.setBrand(carDTO.getBrand());
		car.setModel(carDTO.getModel());
		car.setYear(carDTO.getYear());
		car.setColor(carDTO.getColor());
		car.setBodyType(carDTO.getBodyType());
	}
}
