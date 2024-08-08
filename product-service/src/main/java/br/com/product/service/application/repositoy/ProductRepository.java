package br.com.product.service.application.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.product.service.application.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
