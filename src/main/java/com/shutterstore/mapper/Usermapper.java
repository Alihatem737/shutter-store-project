package com.shutterstore.mapper;


import com.shutterstore.dto.Userrequestdto;
import com.shutterstore.dto.Userresponsedto;
import com.shutterstore.entity.Userentity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Usermapper {


    Userentity toEntity(Userrequestdto request);

    Userresponsedto toResponse(Userentity entity);
}
