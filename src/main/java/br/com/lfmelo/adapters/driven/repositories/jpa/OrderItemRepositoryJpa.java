package br.com.lfmelo.adapters.driven.repositories.jpa;

import br.com.lfmelo.adapters.driven.entities.OrderItemEntity;
import br.com.lfmelo.adapters.dtos.ProductOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepositoryJpa extends JpaRepository<OrderItemEntity, Long> {

    @Query(value = """
            SELECT tp.id, tp.name, tp.price, tp.description, tp.type_product FROM TBL_PRODUCT tp
            INNER JOIN TBL_ORDER_ITEM toi
            ON tp.id = toi.id_product
            WHERE toi.id_order = :id
            """, nativeQuery = true)
    List<ProductOrderDTO> findAllByIdOrder(@Param("id") Long id);
}
