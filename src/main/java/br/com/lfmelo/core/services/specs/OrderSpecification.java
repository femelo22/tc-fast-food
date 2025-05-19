package br.com.lfmelo.core.services.specs;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.dtos.OrderFilterDTO;
import br.com.lfmelo.adapters.dtos.ProductFilterDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderSpecification {

    //TODO: IMPLEMENTAR CORRETAMENTE

    private final String ATT_ID = "id";
    private final String ATT_CATEGORY = "status";
    private final String ATT_NAME = "alias";
    private final String ATT_DESCRIPTION = "orderDate";
    private final String ATT_PRICE = "total";
    private final String ATT_CLIENT = "client";

    public Specification<OrderEntity> getFilter(OrderFilterDTO dto) {
        return (root, query, criteriaBuilder) ->
            Specification.where(attributeEquals(ATT_ID, dto.getId()))
                    .toPredicate(root, query, criteriaBuilder);
    }

    public Specification<OrderEntity> attributeEquals(String attribute, Object value) {
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
