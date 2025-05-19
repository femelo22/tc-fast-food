package br.com.lfmelo.adapters.driven.repositories.impl;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.adapters.driven.repositories.jpa.ClientRepositoryJpa;
import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.ports.ClientRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepositoryPort {

    @Autowired
    private ClientRepositoryJpa clientRepositoryJpa;

    @Override
    public ClientEntity findByCpf(String cpf) {
        return this.clientRepositoryJpa.findByCpf(cpf);
    }

    @Override
    public ClientEntity create(Client client) {
        ClientEntity clientEntity = new ClientEntity(client);
        return this.clientRepositoryJpa.save(clientEntity);
    }

    @Override
    public Boolean existsByNameAndEmail(String name, String email) {
        return this.clientRepositoryJpa.existsByNameAndEmail(name, email);
    }
}