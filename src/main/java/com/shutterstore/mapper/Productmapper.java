package com.shutterstore.mapper;

import com.shutterstore.dto.Productrequestdto;
import com.shutterstore.dto.Productresponsedto;
import com.shutterstore.entity.Productentity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface Productmapper {

    @Mapping(source = "description", target = "descrption")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "catagory", ignore = true)
    @Mapping(target = "is_available", ignore = true)
    @Mapping(target = "productimages", ignore = true)
    @Mapping(target = "productattributes", ignore = true)
    Productentity toentity(Productrequestdto request);

    @Mapping(source = "descrption", target = "description")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "catagory.id", target = "categoryId")
    @Mapping(source = "brand.name", target = "brandname")
    @Mapping(source = "catagory.name", target = "categoryname")
    Productresponsedto toresponse(Productentity entity);

    List<Productresponsedto> toresponselist(List<Productentity> entities);


}
