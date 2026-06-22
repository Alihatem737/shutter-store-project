package com.shutterstore.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderresponsedto {

    private Long id;
    private Long userId;
    private BigDecimal totalPrice;
    private String status;
    private LocalDateTime createdAt;
    private String shippingAddress;
    private List<Orderitemresponsedto> items;
}
