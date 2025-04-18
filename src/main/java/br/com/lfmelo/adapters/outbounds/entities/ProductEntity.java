package br.com.lfmelo.adapters.outbounds.entities;

import br.com.lfmelo.domains.enums.TypeProduct;
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
    private TypeProduct type;
}
