package com.shutterstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderitemresponsedto {

    private Long id;
    private Long productid ;
    private String productname;
    private Integer quantity;
    private BigDecimal unitprice;
}
