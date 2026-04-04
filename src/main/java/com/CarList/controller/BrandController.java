package com.CarList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarList.dto.BrandDTO;
import com.CarList.repository.BrandRepository;
import com.CarList.service.BrandService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {


	private BrandService brandService;

	
	// Create Brand
	@PostMapping
	public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
		return new ResponseEntity<> (brandService.createBrand(brandDTO),HttpStatus.CREATED);
	}
	
	// Get all Brands
	@GetMapping
	public List<BrandDTO> getAllBrands() {
		return brandService.getAllBrands();
	}
	
	// Get Brand By id
	@GetMapping("/{id}")
	public BrandDTO getBrandById(@PathVariable Long id) {
		return brandService.getBrandById(id);
	}
	
	// Brand delete by id
	@DeleteMapping("/{id}")
	public String deleteBrand(@PathVariable Long id) {
		return brandService.deleteBrand(id); 
		
	}
}
