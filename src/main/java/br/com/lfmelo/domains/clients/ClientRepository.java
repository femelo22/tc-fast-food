package br.com.lfmelo.domains.clients;

public interface ClientRepository {
    //Aqui vamos implementar o contrato dos métodos que serão implementados pelo ClientReposityJpa

    Client findByCpf(String cpf);

    Client create(Client client);
}
