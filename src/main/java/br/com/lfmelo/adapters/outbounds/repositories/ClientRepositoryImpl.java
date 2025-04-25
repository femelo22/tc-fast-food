package br.com.lfmelo.adapters.outbounds.repositories;

import br.com.lfmelo.adapters.outbounds.entities.ClientEntity;
import br.com.lfmelo.domains.clients.Client;
import br.com.lfmelo.domains.clients.ClientRepository;

public class ClientRepositoryImpl implements ClientRepository {

    private final ClientRepositoryJpa clientRepository;

    public ClientRepositoryImpl(ClientRepositoryJpa clientRepository) {
        this.clientRepository = clientRepository;
    }

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
