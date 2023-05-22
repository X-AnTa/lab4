package com.anta.lab4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "cars")
@ToString
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id", nullable = false)
	private Integer id;
	@Column(name = "brand", nullable = false)
	private String brand;
	@Column(name = "model", nullable = false)
	private String model;
	@Column(name = "year", nullable = false)
	private String year;
	@Column(name = "color", nullable = false)
	private String color;
	@Column(name = "body_type", nullable = false)
	private String bodyType;

}
