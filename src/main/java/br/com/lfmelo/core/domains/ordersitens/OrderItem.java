package br.com.lfmelo.core.domains.ordersitens;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.driven.entities.ProductEntity;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;

    private Integer amount;

    private BigDecimal unitPrice;

    private String note;

    private OrderEntity order;

    private ProductEntity product;

    public OrderItem() {
    }

    public OrderItem(Long id, Integer amount, BigDecimal unitPrice, String note, OrderEntity order, ProductEntity product) {
        this.id = id;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.note = note;
        this.order = order;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
