package br.com.product.service.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.product.service.application.model.Product;
import br.com.product.service.application.model.dto.ProductDTO;
import br.com.product.service.application.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		log.info("[getAll] Get all product");
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> getById(@PathVariable Long id){
		log.info("[getById] Get product by id: {}", id);
		return ResponseEntity.ok(service.findById(id));
	}
	
}
