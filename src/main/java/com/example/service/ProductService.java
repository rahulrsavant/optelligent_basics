package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.repository.ProductRepository;

import lombok.extern.log4j.Log4j;

//import com.howtodoinjava.demo.jackson.Jackson2Demo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;

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
	
	public void getExcel() {
		try {
		FileInputStream file = new FileInputStream("/home/rahul/Documents/test.xlsx");
		IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

		//Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) 
		{
			Row row = rowIterator.next();
			//For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) 
			{
				Cell cell = cellIterator.next();
				//Check the cell type and format accordingly
				switch (cell.getCellType()) 
				{
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					default:
						throw new IllegalStateException("Unexpected value: " + cell.getCellType());
				}
			}
			System.out.println("");
		}
		file.close();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	}

}
