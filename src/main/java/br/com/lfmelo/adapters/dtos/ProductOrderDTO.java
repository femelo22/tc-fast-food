package br.com.lfmelo.adapters.dtos;

import br.com.lfmelo.core.domains.enums.CategoryProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String typeProduct;
    private Integer amount;
}
