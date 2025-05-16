package br.com.lfmelo.core.services.impl;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.ports.ClientRepositoryPort;
import br.com.lfmelo.core.services.ClientServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientServicePort {

    @Autowired
    private ClientRepositoryPort clientRepositoryPort;

    @Override
    public ClientEntity createUser(Client client) {

        Boolean existsByNameAndEmail = clientRepositoryPort
                .existsByNameAndEmail(client.getName(), client.getEmail());

        if(existsByNameAndEmail) {
            throw new RuntimeException("Cliente já cadastrado!");
        }

        return clientRepositoryPort.create(client);
    }

    @Override
    public ClientEntity findByCpf(String cpf) {
        return clientRepositoryPort.findByCpf(cpf);
    }
}
