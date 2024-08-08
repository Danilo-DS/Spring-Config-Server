package br.com.installment.service.application.dto;

import java.util.List;

import lombok.Builder;

@Builder
public record InstallmentResponse(
	List<Installment> installments
) {}
