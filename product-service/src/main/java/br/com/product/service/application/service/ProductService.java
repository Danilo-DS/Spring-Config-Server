package br.com.product.service.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.product.service.application.model.Product;
import br.com.product.service.application.model.dto.InstallmentResponseDTO;
import br.com.product.service.application.model.dto.ProductDTO;
import br.com.product.service.application.repositoy.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private InstallmentService installmentService;
	
	@Transactional(readOnly = true)
	public List<Product> findAll(){
		log.info("[findAll] Find all products");
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		
		log.info("[findById] Find by id: {}", id);
		
		Product product =  repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found"));
		
		InstallmentResponseDTO installmentResponse = installmentService.getInstallments(product);
		
		return buildProductDto(product, installmentResponse);
	}
	
	private ProductDTO buildProductDto(Product product, InstallmentResponseDTO installmentResposne) {
		
		log.info("[buildProductDto] build ProductDto by Product: {}", product.getId());
		
		ProductDTO productDto = ProductDTO.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.totalInstallments(String.format("%dX %s interest", product.getInstallments(), (product.getHasRate() ? "with" :"without")))
				.installments(installmentResposne.installments())
				.build();
		
		return productDto;
	}
	
}
