package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface OrderRepositoryPort {
    Page<OrderEntity> listOrders(Specification<OrderEntity> specification, Pageable pageable);
}
