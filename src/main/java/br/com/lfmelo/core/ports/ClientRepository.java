package br.com.lfmelo.core.ports;

import br.com.lfmelo.core.domains.clients.Client;

public interface ClientRepository {
    //Aqui vamos implementar o contrato dos métodos que serão implementados pelo ClientReposityJpa

    Client findByCpf(String cpf);

    Client create(Client client);
}