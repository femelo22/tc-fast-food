package br.com.lfmelo.adapters.outbounds.repositories;

import br.com.lfmelo.adapters.outbounds.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT * FROM TBL_CLIENTS WHERE cpf = :cpf")
    ClientEntity findByCpf(String cpf);
}
