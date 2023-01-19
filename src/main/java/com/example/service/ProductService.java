package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository repository;
	private ProductMapper productMapper;

	@Autowired
	public ProductService(ProductRepository repository, ProductMapper mapper) {
		this.repository = repository;
		this.productMapper=mapper;
	}

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public ProductDTO getProductByName(String name) {


		System.out.println("*****************" + name);
		name = "product1";
		Product product = repository.findByName(name);

		ProductDTO productDTO = productMapper.getModelFromEntity(product);

		return productDTO;
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed !! " + id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}

}
