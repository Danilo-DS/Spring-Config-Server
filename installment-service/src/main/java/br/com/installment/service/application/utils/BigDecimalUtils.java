package br.com.installment.service.application.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtils {

	public static BigDecimal divide(BigDecimal value, Integer divider, int scale) {
		
		return value.divide(BigDecimal.valueOf(divider), RoundingMode.HALF_EVEN)
			.setScale(scale, RoundingMode.HALF_EVEN);
	}
	
	public static BigDecimal multiply(BigDecimal value, Integer multiplier) {
		
		return value.multiply(BigDecimal.valueOf(multiplier));
	}
}
