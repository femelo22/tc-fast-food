package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.core.domains.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ProductRepositoryPort {
    ProductEntity createProduct(Product product);
    Page<ProductEntity> findProduct(Specification<ProductEntity> specification, Pageable pageable);
    ProductEntity findProductById(Long idProduct);
    void editProduct(ProductEntity product);
    void deleteProduct(ProductEntity product);
}
