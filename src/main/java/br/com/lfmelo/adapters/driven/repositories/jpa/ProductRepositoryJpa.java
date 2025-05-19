package br.com.lfmelo.adapters.driven.repositories.jpa;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
}
