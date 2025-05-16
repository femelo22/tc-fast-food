package br.com.lfmelo.core.services;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.domains.clients.Client;

public interface ClientServicePort {
    ClientEntity createUser(Client client);
    ClientEntity findByCpf(String cpf);
}
