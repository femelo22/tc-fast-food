package br.com.lfmelo.adapters.driven.repositories.impl;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.driven.repositories.jpa.OrderRepositoryJpa;
import br.com.lfmelo.core.ports.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryPort {

    @Autowired
    OrderRepositoryJpa orderRepositoryJpa;

    @Override
    public Page<OrderEntity> listOrders(Specification<OrderEntity> specification, Pageable pageable) {
        return orderRepositoryJpa.findAll(specification, pageable);
    }

    @Override
    public OrderEntity findById(Long id) {
        return orderRepositoryJpa.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Pedido %s não encontrado!", id)));
    }

}
