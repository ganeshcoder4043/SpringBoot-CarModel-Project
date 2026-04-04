package com.CarList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarList.dto.ModelDTO;
import com.CarList.service.ModelService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/model")
@AllArgsConstructor
public class ModelController {
	
	private ModelService modelService;
	
	//Create Model
	@PostMapping                                //  ↓  JSON to Java Object
	public  ResponseEntity<ModelDTO> createModel(@RequestBody ModelDTO modelDTO) {
		return new ResponseEntity<>(modelService.createModel(modelDTO), HttpStatus.CREATED);
	}
	
	// get all model
	@GetMapping
	public List<ModelDTO> getAllModel(){
		return modelService.getAllModel();
	}
	
	// get model by id 
	@GetMapping("/{id}")
	public ModelDTO getModelById(@PathVariable Long id) {
		return modelService.getModelById(id);
	}
	
	@PutMapping("/{id}")
	public ModelDTO udpateModel(@PathVariable Long id, @RequestBody ModelDTO modelDTO) {
		return modelService.udpateModel(id, modelDTO);
	}
	
	@DeleteMapping("/{id}")
	public String deleteModel(@PathVariable Long id) {
		return modelService.deleteModel(id);
		
	}

}
