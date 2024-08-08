package br.com.installment.service.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import br.com.installment.service.application.dto.Installment;
import br.com.installment.service.application.dto.InstallmentRequest;
import br.com.installment.service.application.dto.InstallmentResponse;
import br.com.installment.service.application.utils.BigDecimalUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RefreshScope
public class InstallmentService {

	@Value("${rate-installment}")
	private BigDecimal rate;
	
	public InstallmentResponse get(InstallmentRequest request) {
		
		log.info("[get] Get all installments");
		
		return InstallmentResponse.builder()
				.installments(buildInstallment(request))
				.build();
	}
	
	private List<Installment> buildInstallment(InstallmentRequest request) {
		
		log.info("[buildInstallment] Build Instalments");
		
		Integer totalInstallment = request.getTotalInstalments();
		
		return IntStream.range(1, totalInstallment + 1)
			.mapToObj(calculate(request.getPrice(), request.getContainRate()))
			.collect(Collectors.toList());
	}
	
	private IntFunction<Installment> calculate(BigDecimal price, Boolean hasRate){
		return i -> {
			Installment installment = new Installment()
					.setInstallment(i)
					.setTotal(price);
			
			if (hasRate) {
				installment.applyRate(rate);
				return installment;
			}
			
			return installment.setValue(BigDecimalUtils.divide(price, i, 2));
		};
	}
	
}
