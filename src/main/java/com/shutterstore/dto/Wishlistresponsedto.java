package com.shutterstore.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Wishlistresponsedto {

    private Long id;
    private Long userId;
    private Long productId;
    private String productname;
    private LocalDateTime createdAt;
}
