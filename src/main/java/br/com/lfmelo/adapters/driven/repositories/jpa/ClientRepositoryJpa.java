package br.com.lfmelo.adapters.driven.repositories.jpa;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByCpf(String cpf);
    Boolean existsByNameAndEmail(String name, String email);
}
