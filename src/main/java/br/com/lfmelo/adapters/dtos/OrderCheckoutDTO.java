package br.com.lfmelo.adapters.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderCheckoutDTO {
    private Long clientId;
    private List<OrderItemDTO> orderItems;
    private BigDecimal totalPrice;
}
