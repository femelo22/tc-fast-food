package br.com.lfmelo.adapters.driven.repositories.jpa;

import br.com.lfmelo.adapters.driven.entities.ImageEntity;
import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepositoryJpa extends JpaRepository<ImageEntity, Long> {
    Page<ImageEntity> findAllByProduct(Pageable pageable, ProductEntity product);
}
