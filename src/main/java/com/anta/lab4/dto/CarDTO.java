package com.anta.lab4.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDTO {
	private Integer id;
	private String brand;
	private String model;
	private String year;
	private String color;
	private String bodyType;
}
