package br.com.lfmelo.adapters.driven.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "TBL_IMAGE")
@Table(name = "TBL_IMAGE")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String linkImage;

    private String keyImage;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;
}
