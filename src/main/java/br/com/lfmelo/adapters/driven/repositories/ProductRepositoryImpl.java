package br.com.lfmelo.adapters.driven.repositories;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.core.domains.products.Product;
import br.com.lfmelo.core.ports.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort {

    @Autowired
    private ProductRepositoryJpa productRepositoryJpa;

    @Override
    public ProductEntity createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity(product);
        return productRepositoryJpa.save(productEntity);
    }

    @Override
    public Page<ProductEntity> findProduct(Pageable pageable) {
        return productRepositoryJpa.findAll(pageable);
    }

    @Override
    public ProductEntity findProductById(Long idProduct) {
        return productRepositoryJpa.findById(idProduct)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    @Override
    public void editProduct(ProductEntity product) {
        productRepositoryJpa.save(product);
    }

    @Override
    public void deleteProduct(ProductEntity product) {
        productRepositoryJpa.delete(product);
    }
}
