package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ImageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ImageServicePort {
    ImageEntity saveImage(Long idProduct, MultipartFile file);
    ImageEntity findImageById(Long idImage);
    Page<ImageEntity> listImagesByProduct(Long idProduct, Pageable pageable);
    void deleteImage(Long idImage);
}
