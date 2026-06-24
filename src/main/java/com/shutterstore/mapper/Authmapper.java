package com.shutterstore.mapper;


import com.shutterstore.dto.Registerrequestdto;
import com.shutterstore.dto.Registerresponsedto;
import com.shutterstore.entity.Userentity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface Authmapper {


    Userentity toEntity(Registerrequestdto request);

    Registerresponsedto toResponse(Userentity user);
}
