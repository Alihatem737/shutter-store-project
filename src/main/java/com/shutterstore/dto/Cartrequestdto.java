package com.shutterstore.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cartrequestdto {



    private Long userId;
    private Long productId;
    private Integer quantity;
}
