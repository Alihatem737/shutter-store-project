package com.shutterstore.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reviewrequestdto {


    private Integer rating;
    private String comment;
    private Long productid;
    private Long userid;
}
