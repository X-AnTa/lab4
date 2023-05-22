package com.anta.lab4.mapper;

import com.anta.lab4.dto.CarDTO;
import com.anta.lab4.entity.Car;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class CarMapper {

	@Mapping(target = "id", source = "id")
	public abstract CarDTO mapToCarDTO(Car car);

	@Mapping(target = "id", source = "id")
	public abstract Car mapToCar(CarDTO carDTO);


}
