package com.CarList.mapper;

import com.CarList.dto.BrandDTO;
import com.CarList.entity.Brand;

public class BrandMapper {

	public static BrandDTO toCreateDTO(Brand brand) {
		if(brand == null) {
			return null;
		}
		
		BrandDTO brandDTO =  new BrandDTO();
		brandDTO.setId(brand.getId());
		brandDTO.setName(brand.getName());
		brandDTO.setModels(brand.getModels().stream().map(ModelMapper::toModelDTO).toList());
		return brandDTO;
	}
	
	public static Brand toBrandEntity(BrandDTO brandDTO) {
		Brand brand = new Brand();
		brand.setName(brandDTO.getName());
		return brand;
		
	}
}
