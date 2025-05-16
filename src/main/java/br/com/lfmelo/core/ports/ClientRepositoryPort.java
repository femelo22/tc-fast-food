package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.domains.clients.Client;

public interface ClientRepositoryPort {
    ClientEntity findByCpf(String cpf);
    ClientEntity create(Client client);
    Boolean existsByNameAndEmail(String name, String email);
}