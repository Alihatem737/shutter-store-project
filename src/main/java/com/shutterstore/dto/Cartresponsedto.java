package com.shutterstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cartresponsedto {


    private Long cartId;
    private Long userId;
    private List<Cartitemresponsedto> items;
    private BigDecimal totalPrice;
}
