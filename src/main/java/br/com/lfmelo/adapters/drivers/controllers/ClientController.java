package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.domains.clients.ClientDTO;
import br.com.lfmelo.core.ports.ClientServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientServicePort clientServicePort;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> registerClient(@RequestBody ClientDTO dto) {
        Client client = modelMapper.map(dto, Client.class);
        return new ResponseEntity<>(clientServicePort.createUser(client), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findByCpf(@RequestAttribute("cpf") String cpf) {
        return ResponseEntity.ok().body(clientServicePort.findByCpf(cpf));
    }
}
