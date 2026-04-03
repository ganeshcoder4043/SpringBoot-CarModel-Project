package com.CarList.service;

import org.springframework.stereotype.Service;

import com.CarList.dto.BrandDTO;
import com.CarList.entity.Brand;
import com.CarList.mapper.BrandMapper;
import com.CarList.repository.BrandRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandService {

	private BrandRepository brandRepository;
	
	public BrandDTO createBrand(BrandDTO brandDTO) {
		Brand brand = BrandMapper.toBrandEntity(brandDTO); // DTO to Entity
		Brand save = brandRepository.save(brand); // db Save 
		return BrandMapper.toCreateDTO(brand); // Entity to DTO
	}
}
