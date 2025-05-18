package br.com.lfmelo.adapters.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductFilterDTO {
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String category;

    private BigDecimal priceLassThan;

    private BigDecimal priceGreaterThan;
}
