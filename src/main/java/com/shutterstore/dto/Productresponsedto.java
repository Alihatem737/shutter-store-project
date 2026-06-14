package com.shutterstore.dto;

import com.shutterstore.entity.Brandentity;
import com.shutterstore.entity.Catagoryentity;
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
    private Brandentity brand;
    private Catagoryentity catagory;
    private boolean is_available;
    private String brandname;
    private String categoryname;

}
