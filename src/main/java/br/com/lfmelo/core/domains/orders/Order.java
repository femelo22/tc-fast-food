package br.com.lfmelo.core.domains.orders;

import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.domains.enums.StatusOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private Long id;

    private StatusOrder status;

    private LocalDateTime orderDate;

    private BigDecimal total;

    private Client client;

    public Order() {
    }

    public Order(Long id, StatusOrder status, LocalDateTime orderDate, BigDecimal total, Client client) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.total = total;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
