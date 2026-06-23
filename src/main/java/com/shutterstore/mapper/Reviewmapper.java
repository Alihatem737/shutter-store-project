package com.shutterstore.mapper;



import com.shutterstore.dto.Reviewrequestdto;
import com.shutterstore.dto.Reviewresponsedto;
import com.shutterstore.entity.Reviewentity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Reviewmapper {

    Reviewentity toentity(Reviewrequestdto request);

    Reviewresponsedto toresponse(Reviewentity entity);


}
