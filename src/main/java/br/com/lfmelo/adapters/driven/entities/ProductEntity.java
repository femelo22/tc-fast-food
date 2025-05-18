package br.com.lfmelo.adapters.driven.entities;

import br.com.lfmelo.core.domains.enums.CategoryProduct;
import br.com.lfmelo.core.domains.products.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TBL_PRODUCT")
@Table(name = "TBL_PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", length = 1500)
    private String description;

    @Column(name= "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_product")
    private CategoryProduct category;

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.name = product.getName();
        this.category = product.getCategory();
        this.price = product.getPrice();
    }
}
