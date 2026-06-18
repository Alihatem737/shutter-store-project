package com.shutterstore.services.impl;


import com.shutterstore.dto.Userrequestdto;
import com.shutterstore.dto.Userresponsedto;
import com.shutterstore.entity.Role;
import com.shutterstore.entity.Userentity;
import com.shutterstore.mapper.Usermapper;
import com.shutterstore.repository.Userepo;
import com.shutterstore.services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userserviceimpl implements Userservice {

    @Autowired
    private Userepo userepo;

    @Autowired
    private Usermapper usermapper;


    @Override
    public Userresponsedto registeruser(Userrequestdto request) {

        Userentity user = usermapper.toEntity(request);

        user.setRole(Role.USER);

        Userentity saveduser = userepo.save(user);

        return usermapper.toResponse(saveduser);

    }
}
