package br.com.product.service.application.model.dto;

import java.util.List;

public record InstallmentResponseDTO(
	List<Installment> installments
){}
