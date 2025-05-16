package br.com.lfmelo.core.domains.products;

import br.com.lfmelo.core.domains.enums.CategoryProduct;

import java.math.BigDecimal;

public class Product {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private CategoryProduct category;

    public Product() {}

    public Product(Long id, String name, String description, BigDecimal price, CategoryProduct category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
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

    public CategoryProduct getCategory() {
        return category;
    }

    public void setCategory(CategoryProduct category) {
        this.category = category;
    }
}
