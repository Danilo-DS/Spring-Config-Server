package br.com.product.service.application.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentRequestDTO {
	private BigDecimal price;
	private Boolean containRate;
	private Integer totalInstalments;
}
