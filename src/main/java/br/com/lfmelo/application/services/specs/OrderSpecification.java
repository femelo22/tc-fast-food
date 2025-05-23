package br.com.lfmelo.application.services.specs;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.dtos.OrderFilterDTO;
import br.com.lfmelo.adapters.dtos.ProductFilterDTO;
import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.domains.enums.StatusOrder;
import br.com.lfmelo.core.domains.orders.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class OrderSpecification {

    private final String ATT_ID = "id";
    private final String ATT_STATUS = "status";
    private final String ATT_ALIAS = "alias";
    private final String ATT_ORDER_DATE = "orderDate";
    private final String ATT_TOTAL = "total";
    private final String ATT_CLIENT = "client";

    public Specification<OrderEntity> getFilter(OrderFilterDTO dto) {
        return (root, query, criteriaBuilder) ->
            Specification.where(attributeEquals(ATT_ID, dto.getId()))
                    .and(attributeEquals(ATT_STATUS, dto.getStatus()))
                    .and(attributeContains(ATT_ALIAS, dto.getAlias()))
                    .and(attributeBetween(ATT_ORDER_DATE, dto.getOrderDateInitial(), dto.getOrderDateFinal()))
                    .and(attributeGreaterThan(ATT_TOTAL, dto.getTotalGreaterThan()))
                    .and(attributeLassThan(ATT_TOTAL, dto.getTotalLassThan()))
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

    public Specification<OrderEntity> attributeContains(String attribute, Object value) {
         return (root, query, criteriaBuilder) -> {
             if (value == null) {
                 return null;
             }
             return criteriaBuilder.like(root.get(attribute), "%" + value + "%");
         };
    }

    public Specification<OrderEntity> attributeBetween(String attribute, LocalDateTime date1, LocalDateTime date2) {
        return (root, query, criteriaBuilder) -> {
            if (date1 == null || date2 == null) {
                return null;
            }
            return criteriaBuilder.between(root.get(attribute), date1, date2);
        };
    }

    public Specification<OrderEntity> attributeGreaterThan(String attribute, BigDecimal value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return null;
            }
            return criteriaBuilder.greaterThan(root.get(attribute), value);
        };
    }

    public Specification<OrderEntity> attributeLassThan(String attribute, BigDecimal value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return null;
            }
            return criteriaBuilder.lessThan(root.get(attribute), value);
        };
    }
}
