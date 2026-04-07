package com.CarList.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "model",
        description = "It holds model information."
)
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
