package br.com.product.service.application.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;

@Builder
@JsonInclude(value = Include.NON_NULL)
public record ProductDTO (
	Long id,
	String name,
	BigDecimal price,
	String totalInstallments,
	List<Installment> installments
) {}
