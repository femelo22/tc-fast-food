package br.com.lfmelo.core.services;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.adapters.dtos.OrderFilterDTO;
import br.com.lfmelo.core.ports.OrderRepositoryPort;
import br.com.lfmelo.core.ports.OrderServicePort;
import br.com.lfmelo.core.ports.SqsSenderServicePort;
import br.com.lfmelo.core.services.specs.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderServicePort {

    @Autowired
    private OrderRepositoryPort orderRepositoryPort;

    @Autowired
    private OrderSpecification specification;

    @Autowired
    private SqsSenderServicePort sqsSender;

    @Override
    public Page<OrderEntity> listOrders(Pageable pageable, OrderFilterDTO dto) {
        return orderRepositoryPort.listOrders(specification.getFilter(dto), pageable);
    }

    @Override
    public void sendToQueue(OrderCheckoutDTO order) {
        sqsSender.publish(order);
    }
}
