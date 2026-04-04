package com.CarList.mapper;

import com.CarList.dto.ModelDTO;
import com.CarList.entity.Brand;
import com.CarList.entity.Model;

public class ModelMapper {
	
	// Entity to DTO
	public static ModelDTO toModelDTO(Model model) {
		return new ModelDTO(
				model.getId(),
				model.getName(),
				model.getDescription(),
				model.getPrice(),
				model.getBrand().getId());
	}
	
	// DTO To Entity
	public static Model toModelEntity(ModelDTO modelDTO, Brand brand) {
		Model model = new Model();
		model.setName(modelDTO.getName());
		model.setDescription(modelDTO.getDescription());
		model.setPrice(modelDTO.getPrice());
		model.setBrand(brand);
		return model;
	}
	
	

}
