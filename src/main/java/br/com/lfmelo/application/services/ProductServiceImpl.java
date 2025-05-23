package br.com.lfmelo.application.services;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.dtos.ProductFilterDTO;
import br.com.lfmelo.core.domains.products.Product;
import br.com.lfmelo.core.ports.ProductRepositoryPort;
import br.com.lfmelo.core.ports.ProductServicePort;
import br.com.lfmelo.application.services.specs.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductServicePort {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    @Autowired
    private ProductSpecification specification;

    @Override
    public ProductEntity createProduct(Product product) {
        return productRepositoryPort.createProduct(product);
    }

    @Override
    public Page<ProductEntity> findProduct(Pageable pageable, ProductFilterDTO dto) {
        return productRepositoryPort.findProduct(specification.getFilter(dto), pageable);
    }

    @Override
    public ProductEntity findById(Long idProduct) {
        return productRepositoryPort.findProductById(idProduct);
    }

    @Override
    public void editProduct(Long idProduct, Product product) {
        ProductEntity savedProduct = productRepositoryPort.findProductById(idProduct);
        savedProduct.setCategory(product.getCategory());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setName(product.getName());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setId(idProduct);
        productRepositoryPort.editProduct(savedProduct);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        ProductEntity savedProduct = productRepositoryPort.findProductById(idProduct);
        productRepositoryPort.deleteProduct(savedProduct);
    }
}
