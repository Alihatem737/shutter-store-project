package com.shutterstore.dto;


import com.shutterstore.entity.Productentity;
import com.shutterstore.entity.Userentity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reviewresponsedto {


    private Long id;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Long productid;
    private String productname;
    private Long userid;
    private String username;

}
