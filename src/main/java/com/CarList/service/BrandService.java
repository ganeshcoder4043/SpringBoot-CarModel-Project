package com.CarList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CarList.dto.BrandDTO;
import com.CarList.dto.ModelDTO;
import com.CarList.entity.Brand;
import com.CarList.exception.BrandAlreadyExistsException;
import com.CarList.mapper.BrandMapper;
import com.CarList.mapper.ModelMapper;
import com.CarList.repository.BrandRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandService {

	private BrandRepository brandRepository;
	
	// Create Brand
	public BrandDTO createBrand(BrandDTO brandDTO) {
		Optional<Brand> optionalBrand = brandRepository.findByName(brandDTO.getName());
		if (optionalBrand.isPresent()) {
			throw new BrandAlreadyExistsException("Brand "
		+ brandDTO.getName()+" Already Exists");}
		
		Brand brand = BrandMapper.toBrandEntity(brandDTO); // DTO to Entity
		Brand save = brandRepository.save(brand); // db Save 
		return BrandMapper.toBrandDTO(brand); // Entity to DTO
	}
	
	// Get All Brands 
	public List<BrandDTO> getAllBrands(){
		return brandRepository.findAll().stream().map(BrandMapper::toBrandDTO).toList();
	}
	
	//Get Brand By id
	public BrandDTO getBrandById(Long id) {
		Brand brand = brandRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Brand Not Found!!!!"));
		return BrandMapper.toBrandDTO(brand);
	}
	
	// Delete Brand By id
	public String deleteBrand(Long id) {
		brandRepository.deleteById(id);
		return "YOUR CATEGORY "+ id +" HAS BEEN SUCESSFULLY DELETEDED";
		
	}
	
	
	
	
	
	
}
