package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.adapters.dtos.OrderFilterDTO;
import br.com.lfmelo.core.ports.OrderServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Pedidos", description = "Operações relacionadas à Pedidos")
public class OrderController {

    @Autowired
    private OrderServicePort orderServicePort;

    @Operation(summary = "Enviar pedido para fila de processamento", description = "Realizar checkout de pedido para processamento")
    @ApiResponse(responseCode = "202", description = "Accepted")
    @PostMapping("/checkout")
    public ResponseEntity<?> checkoutOrder(@RequestBody OrderCheckoutDTO dto) {
        orderServicePort.sendToQueue(dto);
        return ResponseEntity.accepted().body("Pedido enviaado para fila!");
    }

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Listar pedidos paginados com filtos", description = "Retorna uma lista paginada de pedidos")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    @GetMapping
    public ResponseEntity<Page<OrderEntity>> listOrders(@PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                        @ModelAttribute OrderFilterDTO filter) {
        return ResponseEntity.ok().body(orderServicePort.listOrders(pageable, filter));
    }

    @Operation(summary = "Listar itens de um pedido", description = "Retorna itens escolhidos por pedido")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    @GetMapping("/{idOrder}/items")
    public ResponseEntity<?> listItemsOrder(@PathVariable Long idOrder) {
        return ResponseEntity.ok().body(orderServicePort.findItemsByOrder(idOrder));
    }
}
