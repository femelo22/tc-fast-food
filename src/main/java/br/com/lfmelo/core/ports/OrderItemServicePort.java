package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.ProductOrderDTO;

import java.util.List;

public interface OrderItemServicePort {
    List<ProductOrderDTO> findItemsByOrder(OrderEntity orderEntity);
}
