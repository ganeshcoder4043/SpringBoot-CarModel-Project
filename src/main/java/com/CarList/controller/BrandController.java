package com.CarList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
        name = "Brand REST API CRUD Operation.",
        description = "Create , Read & Delete Operation For Brand REST API."
)
@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {


	private BrandService brandService;

	
	// Create Brand
	 @ApiResponse(
	          responseCode = "201",
	          description = "Created"
	    )
	    @Operation(
	            summary = "Create new Brand",
	            description = "Create a new Brand by providing brand details in request body"
	    )
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
		return new ResponseEntity<> (brandService.createBrand(brandDTO),HttpStatus.CREATED);
	}
	
	// Get all Brands
	 @Operation(
	            summary = "Get all Brand",
	            description = "Retrieve list of all brand from database"
	    )
	@GetMapping
	public List<BrandDTO> getAllBrands() {
		return brandService.getAllBrands();
	}
	
	// Get Brand By id
	 @Operation(
	            summary = "Get brand by ID",
	            description = "Retrieve a single brand using brand ID"
	    )
	@GetMapping("/{id}")
	public BrandDTO getBrandById(@PathVariable Long id) {
		return brandService.getBrandById(id);
	}
	
	// Brand delete by id
	 @Operation(
	            summary = "Delete brand",
	            description = "Delete brand from database using brand ID")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public String deleteBrand(@PathVariable Long id) {
		return brandService.deleteBrand(id); 
		
	}
}
