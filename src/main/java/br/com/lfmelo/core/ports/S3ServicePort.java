package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.dtos.ImageResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface S3ServicePort {
    ImageResponseDTO uploadToS3(MultipartFile file);
    void deleteFileS3(String key);
}
