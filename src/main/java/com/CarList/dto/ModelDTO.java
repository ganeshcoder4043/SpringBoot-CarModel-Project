package com.CarList.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO {
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Long BrandId;
	
}
