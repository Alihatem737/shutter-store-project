package com.shutterstore.mapper;



import com.shutterstore.dto.Categoryrequestdto;
import com.shutterstore.dto.Categoryresponsedto;

import com.shutterstore.entity.Categoryentity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Categorymapper {

    Categoryentity toentity(Categoryrequestdto request);

    Categoryresponsedto toresponse(Categoryentity entity);

    List<Categoryresponsedto> toresponselist(List<Categoryentity> entities);

}