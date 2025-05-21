package br.com.lfmelo.core.services;

import br.com.lfmelo.adapters.driven.entities.ImageEntity;
import br.com.lfmelo.adapters.dtos.ImageResponseDTO;
import br.com.lfmelo.core.domains.images.Image;
import br.com.lfmelo.core.ports.ImageRepositoryPort;
import br.com.lfmelo.core.ports.ImageServicePort;
import br.com.lfmelo.core.ports.ProductServicePort;
import br.com.lfmelo.core.ports.S3ServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageServicePort {

    @Autowired
    private ImageRepositoryPort imageRepositoryPort;

    @Autowired
    private S3ServicePort s3ServicePort;

    @Autowired
    private ProductServicePort productServicePort;

    @Override
    public ImageEntity saveImage(Long idProduct, MultipartFile file) {
        var product = productServicePort.findById(idProduct);

        var image = new Image();
        ImageResponseDTO imageResponseDTO = s3ServicePort.uploadToS3(file);
        image.setLinkImage(imageResponseDTO.getUrlImage());
        image.setKeyImage(imageResponseDTO.getKeyImage());

        return imageRepositoryPort.save(image, product);
    }

    @Override
    public ImageEntity findImageById(Long idImage) {
        return imageRepositoryPort.findImageById(idImage);
    }

    @Override
    public Page<ImageEntity> listImagesByProduct(Long idProduct, Pageable pageable) {
        var product = productServicePort.findById(idProduct);
        return imageRepositoryPort.listImagesByProduct(product, pageable);
    }

    @Override
    public void deleteImage(Long idImage) {
        var image = findImageById(idImage);
        s3ServicePort.deleteFileS3(image.getKeyImage());
        imageRepositoryPort.delete(image);
    }
}
