package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.dtos.ProductFilterDTO;
import br.com.lfmelo.core.domains.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductServicePort {
    ProductEntity createProduct(Product product);
    Page<ProductEntity> findProduct(Pageable pageable, ProductFilterDTO dto);
    ProductEntity findById(Long idProduct);
    void editProduct(Long idProduct, Product product);
    void deleteProduct(Long idProduct);
}