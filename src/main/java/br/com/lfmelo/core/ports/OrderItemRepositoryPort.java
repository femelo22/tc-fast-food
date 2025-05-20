package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.driven.entities.OrderItemEntity;
import br.com.lfmelo.adapters.dtos.ProductOrderDTO;

import java.util.List;

public interface OrderItemRepositoryPort {
    List<ProductOrderDTO> findAllByOrder(OrderEntity orderEntity);
}
