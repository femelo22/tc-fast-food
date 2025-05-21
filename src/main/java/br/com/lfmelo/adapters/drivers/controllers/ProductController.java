package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.dtos.ProductFilterDTO;
import br.com.lfmelo.core.domains.enums.CategoryProduct;
import br.com.lfmelo.core.domains.products.Product;
import br.com.lfmelo.core.domains.products.ProductForm;
import br.com.lfmelo.core.ports.ProductServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Produtos", description = "Operações relacionadas à Produtos")
public class ProductController {

    @Autowired
    private ProductServicePort productServicePort;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Cadastrar produto", description = "Realizar o cadastro de um produto")
    @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductEntity.class)))
    @PostMapping
    public ResponseEntity<ProductEntity> registerProduct(@RequestBody ProductForm form) {
        try {
            CategoryProduct category = CategoryProduct.valueOf(form.getCategory().toUpperCase());
            Product product = modelMapper.map(form, Product.class);
            product.setCategory(category);
            return new ResponseEntity<>(productServicePort.createProduct(product), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Operation(summary = "Listar produtos paginados com filtos", description = "Retorna uma lista paginada de produtos")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    @GetMapping
    public ResponseEntity<Page<ProductEntity>> listProducts(@PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                       @ModelAttribute ProductFilterDTO filter) {
        return ResponseEntity.ok().body(productServicePort.findProduct(pageable, filter));
    }

    @Operation(summary = "Consultar produto por ID", description = "Retorna um produto")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductEntity.class)))
    @GetMapping("/{idProduct}")
    public ResponseEntity<?> findById(@PathVariable Long idProduct) {
        return ResponseEntity.ok().body(productServicePort.findById(idProduct));
    }

    @Operation(summary = "Editar produto", description = "Realizar a atulização das informações de um produto")
    @ApiResponse(responseCode = "204", description = "No Content")
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

    @Operation(summary = "Deletar produto", description = "Realizar exclusão de um produto")
    @ApiResponse(responseCode = "204", description = "No Content")
    @DeleteMapping("/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idProduct) {
        productServicePort.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }

}
