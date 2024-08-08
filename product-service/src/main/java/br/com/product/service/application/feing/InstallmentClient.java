package br.com.product.service.application.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.product.service.application.model.dto.InstallmentRequestDTO;
import br.com.product.service.application.model.dto.InstallmentResponseDTO;

@FeignClient(name = "installmentClient")
public interface InstallmentClient {

	@GetMapping
	public InstallmentResponseDTO getInstallments(@SpringQueryMap InstallmentRequestDTO request);
}
