package com.example.controller;

import com.example.dto.ProductDTO;

//some changes
///some more changes
//



import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
	
	
	private ProductService service;
	


    public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public ProductDTO findProductByName(@PathVariable String name) {
        
        ProductDTO productDTO=service.getProductByName(name);
        return productDTO;
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
