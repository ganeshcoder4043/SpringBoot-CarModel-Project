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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
        name = "Model REST API CRUD Operation.",
        description = "Create , Read, Update, & Delete Operation For Model REST API."
)
@RestController
@RequestMapping("/api/model")
@AllArgsConstructor
public class ModelController {
	
	private ModelService modelService;
	
	//Create Model
	@ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @Operation(
            summary = "Create new model",
            description = "Create a new model by providing model details in request body"
    )
	@PostMapping                                //  ↓  JSON to Java Object
	public  ResponseEntity<ModelDTO> createModel(@RequestBody ModelDTO modelDTO) {
		return new ResponseEntity<>(modelService.createModel(modelDTO), HttpStatus.CREATED);
	}
	
	// get all model
	 @Operation(
	            summary = "Get all model",
	            description = "Retrieve list of all available model from database"
	    )
	@GetMapping
	public List<ModelDTO> getAllModel(){
		return modelService.getAllModel();
	}
	
	// get model by id 
	 @Operation(
	            summary = "Get model by ID",
	            description = "Retrieve a single model using model ID"
	    )
	@GetMapping("/{id}")
	public ModelDTO getModelById(@PathVariable Long id) {
		return modelService.getModelById(id);
	}
	
	 // update by id
	@PutMapping("/{id}")
	@Operation(
            summary = "Update model",
            description = "Update existing model using ID and new model details"
    )
	public ModelDTO udpateModel(@PathVariable Long id, @RequestBody ModelDTO modelDTO) {
		return modelService.udpateModel(id, modelDTO);
	}
	
	// delete by id 
	 @Operation(
	            summary = "Delete model",
	            description = "Delete model from database using model ID"
	    )
	@DeleteMapping("/{id}")
	public String deleteModel(@PathVariable Long id) {
		return modelService.deleteModel(id);
		
	}

}
