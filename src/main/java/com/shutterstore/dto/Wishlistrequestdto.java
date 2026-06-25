package com.shutterstore.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wishlistrequestdto {
    @NotNull(message = "User id is required")
    private Long userId;
    @NotNull(message = "Product id is required")
    private Long productId;
}
