package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.domains.clients.ClientForm;
import br.com.lfmelo.core.ports.ClientServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clientes", description = "Operações relacionadas à Cliente")
public class ClientController {

    @Autowired
    private ClientServicePort clientServicePort;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Registrar cliente", description = "Cria um novo cliente com cpf, nome e e-mail")
    @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping
    public ResponseEntity<?> registerClient(@RequestBody @Valid ClientForm form) {
        Client client = modelMapper.map(form, Client.class);
        return new ResponseEntity<>(clientServicePort.createUser(client), HttpStatus.CREATED);
    }

    @Operation(summary = "Consultar cliente por CPF", description = "Retorna um cliente")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientEntity.class)))
    @GetMapping
    public ResponseEntity<ClientEntity> findByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok().body(clientServicePort.findByCpf(cpf));
    }
}
