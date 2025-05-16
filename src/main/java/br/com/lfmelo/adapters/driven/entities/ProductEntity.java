package br.com.lfmelo.adapters.driven.entities;

import br.com.lfmelo.core.domains.enums.CategoryProduct;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
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
    private CategoryProduct type;
}
