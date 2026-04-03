package com.CarList.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarList.dto.BrandDTO;
import com.CarList.service.BrandService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {

	private BrandService brandService;
	
	@PostMapping
	public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
		return new ResponseEntity<> (brandService.createBrand(brandDTO),HttpStatus.CREATED);
	}
}
