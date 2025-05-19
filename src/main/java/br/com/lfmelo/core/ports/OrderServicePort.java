package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.adapters.dtos.OrderFilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderServicePort {
    Page<OrderEntity> listOrders(Pageable pageable, OrderFilterDTO dto);
    void sendToQueue(OrderCheckoutDTO order);
}
