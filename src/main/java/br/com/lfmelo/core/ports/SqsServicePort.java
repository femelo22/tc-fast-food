package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;

public interface SqsServicePort {
    void publishQueue(OrderCheckoutDTO dto);
}
