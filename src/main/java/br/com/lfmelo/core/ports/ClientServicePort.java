package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.domains.clients.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientServicePort {
    ClientEntity createUser(Client client);
    ClientEntity findByCpf(String cpf);
}
