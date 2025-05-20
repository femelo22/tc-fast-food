package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.adapters.dtos.OrderFilterDTO;
import br.com.lfmelo.adapters.dtos.ProductFilterDTO;
import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.domains.clients.ClientForm;
import br.com.lfmelo.core.ports.ClientServicePort;
import br.com.lfmelo.core.ports.OrderServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderServicePort orderServicePort;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/checkout")
    public ResponseEntity<?> checkoutOrder(@RequestBody OrderCheckoutDTO dto) {
        orderServicePort.sendToQueue(dto);
        return ResponseEntity.ok().body("Pedido enviaado para fila!");
    }

    @GetMapping
    public ResponseEntity<?> listOrders(@PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                        @ModelAttribute OrderFilterDTO filter) {
        return ResponseEntity.ok().body(orderServicePort.listOrders(pageable, filter));
    }

    @GetMapping("/{idOrder}/items")
    public ResponseEntity<?> listItemsOrder(@PathVariable Long idOrder) {
        return ResponseEntity.ok().body(orderServicePort.findItemsByOrder(idOrder));
    }
}
