package com.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.dto.ProductDTO;
import com.example.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  
	ProductMapper MAPPER=Mappers.getMapper(ProductMapper.class);
	
	@Mapping(target="productName",source="name")
	ProductDTO getModelFromEntity(Product product);
	
	@Mapping(target="name",source="productName")
	Product getEntityFromModel(ProductDTO product);
}
