package com.CarList.dto;

import java.util.ArrayList;
import java.util.List;

import com.CarList.entity.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Brand",
        description = "It holds brand information along with their model."
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {
	
	private Long id;
	private String name;
	private List<ModelDTO> models;
}
