package br.com.lfmelo.core.services;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.dtos.ProductFilterDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.math.BigDecimal;

@Component
public class ProductSpecification {

    private final String ATT_ID = "id";
    private final String ATT_CATEGORY = "category";
    private final String ATT_NAME = "name";
    private final String ATT_DESCRIPTION = "description";
    private final String ATT_PRICE = "price";

    public Specification<ProductEntity> getFilter(ProductFilterDTO dto) {
        return (root, query, criteriaBuilder) ->
            Specification.where(attributeEquals(ATT_ID, dto.getId())
                .and(attributeContains(ATT_CATEGORY, dto.getCategory()))
                .and(attributeContains(ATT_DESCRIPTION, dto.getDescription()))
                .and(attributeContains(ATT_NAME, dto.getName())))
                .and(attributeGreaterThan(ATT_PRICE, dto.getPriceGreaterThan()))
                .and((attributeLassThan(ATT_PRICE, dto.getPriceLassThan())))
                .toPredicate(root, query, criteriaBuilder);
    }

    public Specification<ProductEntity> attributeEquals(String attribute, Object value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get(attribute), value);
        };
    }

    public Specification<ProductEntity> attributeContains(String attribute, Object value) {
         return (root, query, criteriaBuilder) -> {
             if (value == null) {
                 return null;
             }
             return criteriaBuilder.like(root.get(attribute), "%" + value + "%");
         };
    }

    public Specification<ProductEntity> attributeGreaterThan(String attribute, BigDecimal value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return null;
            }
            return criteriaBuilder.greaterThan(root.get(attribute), value);
        };
    }

    public Specification<ProductEntity> attributeLassThan(String attribute, BigDecimal value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return null;
            }
            return criteriaBuilder.lessThan(root.get(attribute), value);
        };
    }
}
