package com.shutterstore.dto;

import com.shutterstore.entity.*;
import jakarta.persistence.*;
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
public class Productrequestdto {

    private String name;
    private String description;
    private BigDecimal price ;
    private Integer  stock ;
    private Condition condition ;
    private Brandentity brand;
    private Catagoryentity catagory;
    private Long brandId;
    private Long categoryId;


}
