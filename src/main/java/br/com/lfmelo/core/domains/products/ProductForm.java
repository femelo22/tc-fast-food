package br.com.lfmelo.core.domains.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {

    private String name;

    private String description;

    private BigDecimal price;

    private String category;
}
