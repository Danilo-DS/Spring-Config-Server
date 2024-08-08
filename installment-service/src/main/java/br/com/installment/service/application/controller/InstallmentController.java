package br.com.installment.service.application.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.installment.service.application.dto.InstallmentRequest;
import br.com.installment.service.application.dto.InstallmentResponse;
import br.com.installment.service.application.service.InstallmentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@RestController
public class InstallmentController {

	@Autowired
	private InstallmentService service;
	
	@Value("${rate-installment}")
	private BigDecimal rate;
	
	@GetMapping
	public ResponseEntity<InstallmentResponse> getInstallments(InstallmentRequest request){
		log.info("[getInstallments] Params {}", request);
		return ResponseEntity.ok(service.get(request));
	}
	
	@GetMapping("/rate")
	public ResponseEntity<BigDecimal> getRate(){
		return ResponseEntity.ok(rate);
	}
}
