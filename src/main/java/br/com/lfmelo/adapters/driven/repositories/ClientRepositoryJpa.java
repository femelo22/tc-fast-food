package br.com.lfmelo.adapters.driven.repositories;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT * FROM TBL_CLIENTS WHERE cpf = :cpf")
    ClientEntity findByCpf(String cpf);
}
