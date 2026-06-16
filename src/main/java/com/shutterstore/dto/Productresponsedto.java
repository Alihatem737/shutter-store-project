package com.shutterstore.dto;

import com.shutterstore.entity.Condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Productresponsedto {


    private Long id;
    private String name;
    private String description;
    private BigDecimal price ;
    private Integer  stock ;
    private Condition condition ;
    private Long brandId;
    private Long categoryId;
    private Boolean is_available;
    private String brandname;
    private String categoryname;

}
