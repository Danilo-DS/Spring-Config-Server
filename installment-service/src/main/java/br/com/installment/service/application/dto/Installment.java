package br.com.installment.service.application.dto;

import java.math.BigDecimal;

import br.com.installment.service.application.utils.BigDecimalUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Installment {
	private Integer installment;
	private BigDecimal value;
	private BigDecimal total;
	
	public void applyRate(BigDecimal rate) {
		
		if (installment.equals(1)) {
			setValue(this.total);
			return;
		}
		
		BigDecimal rateByInstallment = this.installment.equals(2) ? rate : BigDecimalUtils.multiply(rate, installment);
		BigDecimal rateOnTotal = BigDecimalUtils.divide(this.total.multiply(rateByInstallment), 100, 2);
		
		setValue(BigDecimalUtils.divide(this.total.add(rateOnTotal), this.installment, 2));
		setTotal(BigDecimalUtils.multiply(getValue(), installment));
	}
	
	public String getDescription() {
		return String.format("%dX R$ %.2f - R$ %.2f", this.installment, this.value, this.total);
	}
}
