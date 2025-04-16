package br.com.lfmelo.domains.images;

import br.com.lfmelo.domains.products.Product;

public class Image {

    private Long id;

    private String linkImage;

    private String keyImage;

    private Product product;

    public Image() {
    }

    public Image(Long id, String linkImage, String keyImage, Product product) {
        this.id = id;
        this.linkImage = linkImage;
        this.keyImage = keyImage;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getKeyImage() {
        return keyImage;
    }

    public void setKeyImage(String keyImage) {
        this.keyImage = keyImage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
