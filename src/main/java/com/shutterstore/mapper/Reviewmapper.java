package com.shutterstore.mapper;



import com.shutterstore.dto.Reviewrequestdto;
import com.shutterstore.dto.Reviewresponsedto;
import com.shutterstore.entity.Reviewentity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Reviewmapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "product", ignore = true)
    Reviewentity toentity(Reviewrequestdto request);

    @Mapping(source = "product.id", target = "productid")
    @Mapping(source = "product.name", target = "productname")
    @Mapping(source = "user.id", target = "userid")
    @Mapping(source = "user.name", target = "username")
    Reviewresponsedto toresponse(Reviewentity entity);



    List<Reviewresponsedto> toResponseList(List<Reviewentity> reviews);


}
