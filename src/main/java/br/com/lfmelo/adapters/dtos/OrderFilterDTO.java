package br.com.lfmelo.adapters.dtos;

import br.com.lfmelo.core.domains.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFilterDTO {
    private Long id;

    private StatusOrder status;

    private String alias;

    private LocalDateTime orderDateInitial;

    private LocalDateTime orderDateFinal;

    private BigDecimal totalGreaterThan;

    private BigDecimal totalLassThan;

    private Long clientId;

    private Long productId;
}
