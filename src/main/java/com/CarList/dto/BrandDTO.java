package com.CarList.dto;

import java.util.ArrayList;
import java.util.List;

import com.CarList.entity.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {
	
	private Long id;
	private String name;
	private List<ModelDTO> models = new ArrayList<>();
}
