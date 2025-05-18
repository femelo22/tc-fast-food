package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.core.domains.enums.CategoryProduct;
import br.com.lfmelo.core.domains.products.Product;
import br.com.lfmelo.core.domains.products.ProductForm;
import br.com.lfmelo.core.ports.ProductServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServicePort productServicePort;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> registerProduct(@RequestBody ProductForm form) {
        try {
            CategoryProduct category = CategoryProduct.valueOf(form.getCategory().toUpperCase());
            Product product = modelMapper.map(form, Product.class);
            product.setCategory(category);
            return new ResponseEntity<>(productServicePort.createProduct(product), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findByCpf(@PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(productServicePort.findProduct(pageable));
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<?> findByCpf(@PathVariable Long idProduct) {
        return ResponseEntity.ok().body(productServicePort.findById(idProduct));
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<?> updateProduct(@PathVariable Long idProduct, @RequestBody ProductForm form) {
        try {
            CategoryProduct category = CategoryProduct.valueOf(form.getCategory().toUpperCase());
            Product product = modelMapper.map(form, Product.class);
            product.setCategory(category);
            productServicePort.editProduct(idProduct, product);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idProduct) {
        productServicePort.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }

}
