package com.shutterstore.mapper;


import com.shutterstore.dto.Brandrequestdto;
import com.shutterstore.dto.Brandresponsedto;
import com.shutterstore.entity.Brandentity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Brandmapper {

    Brandentity toentity(Brandrequestdto request);

    Brandresponsedto toresponse(Brandentity entity);

    List<Brandresponsedto> toresponselist(List<Brandentity> entities);

}
