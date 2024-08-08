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
public class Installment {
	private Integer installment;
	private BigDecimal value;
	private BigDecimal total;
	private String description;
}
