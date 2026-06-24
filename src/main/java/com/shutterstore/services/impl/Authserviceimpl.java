package com.shutterstore.services.impl;

import com.shutterstore.dto.*;
import com.shutterstore.entity.Role;
import com.shutterstore.entity.Userentity;
import com.shutterstore.mapper.Authmapper;
import com.shutterstore.repository.Userrepo;
import com.shutterstore.security.Jwtservice;
import com.shutterstore.services.Authservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class Authserviceimpl implements Authservice {

    @Autowired
    private Userrepo userrepo;

    @Autowired
    private Authmapper authmapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private Jwtservice jwtservice;

    @Override
    public Registerresponsedto register(Registerrequestdto request) {
        Optional<Userentity> user = userrepo.findByEmail(request.getEmail());


        if (user.isPresent()){
            throw  new RuntimeException("email already exist");
        }
        else {

            Userentity newuser = authmapper.toEntity(request);

            newuser.setRole(Role.USER);
            newuser.set_verfied(false);
           String encodedPassword = passwordEncoder.encode(newuser.getPassword());
           newuser.setPassword(encodedPassword);

            Userentity saveduser =    userrepo.save(newuser);


            Registerresponsedto dto = authmapper.toResponse(saveduser);

            return  dto;

        }
    }

    @Override
    public Loginresponsedto login(Loginrequestdto request) {

        Optional<Userentity> user = userrepo.findByEmail(request.getEmail());

        if (user.isEmpty()){
            throw new RuntimeException("Invalid email or password");
        }
        else {

            Userentity foundUser = user.get();

          if ( !passwordEncoder.matches(request.getPassword()
                  ,foundUser.getPassword()) ){
              throw new RuntimeException("Invalid email or password");
          }
          else {
              String token = jwtservice.generateToken(
                      foundUser.getEmail()
              );

              Loginresponsedto response = Loginresponsedto.builder()
                      .token(token)
                      .build();

              return response;
          }
        }

    }
}
