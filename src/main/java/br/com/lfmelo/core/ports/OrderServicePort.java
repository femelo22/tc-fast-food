package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.adapters.dtos.OrderFilterDTO;
import br.com.lfmelo.adapters.dtos.ProductOrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderServicePort {
    Page<OrderEntity> listOrders(Pageable pageable, OrderFilterDTO dto);
    void sendToQueue(OrderCheckoutDTO order);
    List<ProductOrderDTO> findItemsByOrder(Long idOrder);
    OrderEntity findById(Long id);
}
