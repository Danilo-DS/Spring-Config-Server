package br.com.product.service.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.product.service.application.feing.InstallmentClient;
import br.com.product.service.application.model.Product;
import br.com.product.service.application.model.dto.InstallmentRequestDTO;
import br.com.product.service.application.model.dto.InstallmentResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InstallmentService {

	@Autowired
	private InstallmentClient installmenteClient;
	
	public InstallmentResponseDTO getInstallments(Product product) {
		
		log.info("[getInstallments] Get installments product {}", product.getId());
		
		InstallmentRequestDTO request = InstallmentRequestDTO.builder()
			.price(product.getPrice())
			.containRate(product.getHasRate())
			.totalInstalments(product.getInstallments())
			.build();
		
		return installmenteClient.getInstallments(request);
	}
}
