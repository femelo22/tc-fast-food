package br.com.lfmelo.application.services;

import br.com.lfmelo.adapters.dtos.ImageResponseDTO;
import br.com.lfmelo.core.ports.S3ServicePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.util.UUID;

@Service
@Slf4j
public class S3ServiceImpl implements S3ServicePort {

    @Value("${amazon.s3.bucket-name}")
    private String bucketName;

    @Autowired
    private S3Client s3Client;

    @Override
    public ImageResponseDTO uploadToS3(MultipartFile file) {
        String key = UUID.randomUUID().toString().substring(0, 7) + "-" + file.getOriginalFilename();
        try {
            PutObjectRequest putRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(file.getContentType())
                    //.acl(ObjectCannedACL.PUBLIC_READ) Deixar imagem publica
                    .build();

            PutObjectResponse putObjectResponse = s3Client.putObject(putRequest, RequestBody.fromBytes(file.getBytes()));
            log.info(putObjectResponse.toString());
            log.info("Imagem salva!");

            String fileUrl = String.format(
                    "https://%s.s3.%s.amazonaws.com/%s",
                    bucketName,
                    "sa-east-1",
                    key
            );

            return new ImageResponseDTO(key, fileUrl);
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Falha ao realizar upload da imagem: %s", ex.getMessage()));
        }
    }

    @Override
    public void deleteFileS3(String key) {
        DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        DeleteObjectResponse deleteObjectResponse = s3Client.deleteObject(deleteRequest);
        log.info(deleteObjectResponse.toString());
        log.info("Imagem deletada!");
    }
}
