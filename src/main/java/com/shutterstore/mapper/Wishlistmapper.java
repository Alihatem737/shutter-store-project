package com.shutterstore.mapper;




import com.shutterstore.dto.Wishlistrequestdto;

import com.shutterstore.dto.Wishlistresponsedto;
import com.shutterstore.entity.Wishlistentity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface Wishlistmapper {

    Wishlistentity toentity(Wishlistrequestdto request);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productname", source = "product.name")
    Wishlistresponsedto torespone(Wishlistentity entity);


}
