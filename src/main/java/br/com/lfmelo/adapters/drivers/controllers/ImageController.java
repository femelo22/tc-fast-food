package br.com.lfmelo.adapters.drivers.controllers;

import br.com.lfmelo.adapters.driven.entities.ImageEntity;
import br.com.lfmelo.core.ports.ImageServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
@Tag(name = "Imagens", description = "Operações relacionadas à Imagem")
public class ImageController {

    @Autowired
    private ImageServicePort imageServicePort;

    @Operation(summary = "Cadastrar imagem", description = "Anexar imagem ao produto")
    @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ImageEntity.class)))
    @PostMapping("/product/{idProduct}")
    public ResponseEntity<?> uploadImage(@PathVariable("idProduct") Long idProduct,
                                         @RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(imageServicePort.saveImage(idProduct, file));
    }

    @Operation(summary = "Listar imagens de produtos paginadas", description = "Retorna uma lista paginada de imagens de um determinado produto")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    @GetMapping("/product/{idProduct}")
    public ResponseEntity<?> listImages(@PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                                          @PathVariable("idProduct") Long idProduct) {
        return ResponseEntity.ok().body(imageServicePort.listImagesByProduct(idProduct, pageable));
    }

    @Operation(summary = "Deletar imagem", description = "Realizar exclusão de uma imagem")
    @ApiResponse(responseCode = "204", description = "No Content")
    @DeleteMapping("/{idImage}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idImage) {
        imageServicePort.deleteImage(idImage);
        return ResponseEntity.noContent().build();
    }

}
