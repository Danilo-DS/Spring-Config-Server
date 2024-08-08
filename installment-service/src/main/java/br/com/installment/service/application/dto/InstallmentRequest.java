package br.com.installment.service.application.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstallmentRequest {
	
	private BigDecimal price;
	private Boolean containRate;
	private Integer totalInstalments;
}
