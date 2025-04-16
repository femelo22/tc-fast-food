package br.com.lfmelo.domains.payments;

import br.com.lfmelo.adapters.outbounds.entities.OrderEntity;
import br.com.lfmelo.domains.enums.TypePayment;

import java.math.BigDecimal;

public class Payment {

    private Long id;

    private BigDecimal value;

    private TypePayment type;

    private OrderEntity order;

    public Payment() {
    }

    public Payment(Long id, BigDecimal value, TypePayment type, OrderEntity order) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TypePayment getType() {
        return type;
    }

    public void setType(TypePayment type) {
        this.type = type;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
