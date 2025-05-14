package br.com.lfmelo.core.domains.products;

import br.com.lfmelo.core.domains.enums.TypeProduct;

import java.math.BigDecimal;

public class Product {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private TypeProduct type;

    public Product() {}

    public Product(Long id, String name, String description, BigDecimal price, TypeProduct type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }
}
