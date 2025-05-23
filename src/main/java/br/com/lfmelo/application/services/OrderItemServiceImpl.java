package br.com.lfmelo.application.services;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.ProductOrderDTO;
import br.com.lfmelo.core.ports.OrderItemRepositoryPort;
import br.com.lfmelo.core.ports.OrderItemServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemServicePort {

    @Autowired
    private OrderItemRepositoryPort orderItemRepositoryPort;

    @Override
    public List<ProductOrderDTO> findItemsByOrder(OrderEntity orderEntity) {
        return orderItemRepositoryPort.findAllByOrder(orderEntity);
    }
}
