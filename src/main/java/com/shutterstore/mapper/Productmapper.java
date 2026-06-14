package com.shutterstore.mapper;

import com.shutterstore.dto.Productrequestdto;
import com.shutterstore.dto.Productresponsedto;
import com.shutterstore.entity.Productentity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface Productmapper {

    Productentity toentity(Productrequestdto request);

    Productresponsedto toresponse(Productentity entity);

    List<Productresponsedto> toresponselist(List<Productentity> entities);


}
