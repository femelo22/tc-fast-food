package br.com.lfmelo.adapters.driven.repositories;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.domains.clients.Client;
import br.com.lfmelo.core.ports.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private ClientRepositoryJpa clientRepository;

    @Override
    public Client findByCpf(String cpf) {
//        return this.clientRepository.findByCpf(cpf);
        return null;
    }

    @Override
    public Client create(Client client) {
        ClientEntity clientEntity = new ClientEntity(client);
//        return this.clientRepository.save(client);
        return null;
    }
}