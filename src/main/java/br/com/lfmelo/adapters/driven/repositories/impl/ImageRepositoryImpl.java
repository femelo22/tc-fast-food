package br.com.lfmelo.adapters.driven.repositories.impl;

import br.com.lfmelo.adapters.driven.entities.ImageEntity;
import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.driven.repositories.jpa.ImageRepositoryJpa;
import br.com.lfmelo.core.domains.images.Image;
import br.com.lfmelo.core.ports.ImageRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepositoryImpl implements ImageRepositoryPort {

    @Autowired
    private ImageRepositoryJpa imageRepositoryJpa;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ImageEntity save(Image image, ProductEntity product) {
        var imageEntity = modelMapper.map(image, ImageEntity.class);
        imageEntity.setProduct(product);
        return imageRepositoryJpa.save(imageEntity);
    }

    @Override
    public ImageEntity findImageById(Long idImage) {
        return imageRepositoryJpa.findById(idImage)
                .orElseThrow(() -> new RuntimeException(String.format("Imagem %s não encontrada!", idImage)));
    }

    @Override
    public Page<ImageEntity> listImagesByProduct(ProductEntity product, Pageable pageable) {
        return imageRepositoryJpa.findAllByProduct(pageable, product);
    }

    @Override
    public void delete(ImageEntity image) {
        var imageEntity = modelMapper.map(image, ImageEntity.class);
        imageRepositoryJpa.delete(imageEntity);
    }
}
