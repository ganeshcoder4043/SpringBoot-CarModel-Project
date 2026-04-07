package com.CarList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CarList.dto.BrandDTO;
import com.CarList.dto.ModelDTO;
import com.CarList.entity.Brand;
import com.CarList.entity.Model;
import com.CarList.exception.BrandNotFoundException;
import com.CarList.mapper.BrandMapper;
import com.CarList.mapper.ModelMapper;
import com.CarList.repository.BrandRepository;
import com.CarList.repository.ModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelService {
	
	private BrandRepository brandRepository;
	private ModelRepository modelRepository;
	
	// Create Model
	public ModelDTO createModel(ModelDTO modelDTO) {
		// check brand have ya not
		Brand brand =brandRepository.findById(modelDTO.getBrandId())
		.orElseThrow(() -> new BrandNotFoundException("Brand "+modelDTO.getBrandId()+" Not Found!!!!"));
		
		// DTO to Entity
		Model model = ModelMapper.toModelEntity(modelDTO, brand );
		modelRepository.save(model); // save in db
		return ModelMapper.toModelDTO(model); // entity to DTO
	}
	
	// Get all model
	public List<ModelDTO> getAllModel(){
		return modelRepository.findAll().stream().map(ModelMapper::toModelDTO).toList();
	}
	
	// Get model by id
	public ModelDTO getModelById(Long id) {
		Model model = modelRepository.findById(id).orElseThrow(() -> new RuntimeException("Model Not Found!!!!"));
		return ModelMapper.toModelDTO(model);
	}
	
	// model update 
	
	public ModelDTO udpateModel(Long id, ModelDTO modelDTO) {
		
		Model model = modelRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Model Not Found!!!!"));
		
		Brand brand = brandRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Brand Not Found!!!!"));
		
		model.setName(modelDTO.getName());
		model.setDescription(modelDTO.getDescription());
		model.setPrice(modelDTO.getPrice());
		model.setBrand(brand);
		
		modelRepository.save(model);
		
		return ModelMapper.toModelDTO(model);
	}
	
	// Model Delete by id
	public String deleteModel(Long id) {
		modelRepository.deleteById(id);
		return "YOUR PRODUCT "+ id +" HAS BEEN SUCESSFULLY DELETEDED";
	}
	

}
