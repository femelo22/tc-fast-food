package br.com.lfmelo.adapters.driven.entities;

import br.com.lfmelo.core.domains.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "TBL_ORDER")
@Table(name = "TBL_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusOrder status;

    @CreatedDate
    private LocalDateTime orderDate;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientEntity client;
}
