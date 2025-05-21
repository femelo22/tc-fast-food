package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ImageEntity;
import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.core.domains.images.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageRepositoryPort {
    ImageEntity save(Image image, ProductEntity product);
    ImageEntity findImageById(Long idImage);
    Page<ImageEntity> listImagesByProduct(ProductEntity product, Pageable pageable);
    void delete(ImageEntity image);
}
