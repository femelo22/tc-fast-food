package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.domains.clients.ClientForm;
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
    public ResponseEntity<?> registerClient(@RequestBody ClientForm form) {
        Client client = modelMapper.map(form, Client.class);
        return new ResponseEntity<>(clientServicePort.createUser(client), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok().body(clientServicePort.findByCpf(cpf));
    }
}
