package com.shutterstore.services.impl;

import com.shutterstore.dto.*;
import com.shutterstore.entity.Role;
import com.shutterstore.entity.Userentity;
import com.shutterstore.entity.VerificationTokenEntity;
import com.shutterstore.mapper.Authmapper;
import com.shutterstore.repository.Userrepo;
import com.shutterstore.repository.Verificationtokenrepo;
import com.shutterstore.security.Jwtservice;
import com.shutterstore.services.Authservice;
import com.shutterstore.services.Emailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class Authserviceimpl implements Authservice {

    @Autowired
    private Userrepo userrepo;

    @Autowired
    private Authmapper authmapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Verificationtokenrepo verificationtokenrepo;


    @Autowired
    private Jwtservice jwtservice;

    @Autowired
    private Emailservice emailservice;

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

            String verificationToken = UUID.randomUUID().toString();

            VerificationTokenEntity tokenEntity = VerificationTokenEntity.builder()
                    .token(verificationToken)
                    .expiresAt(LocalDateTime.now().plusHours(24))
                    .user(saveduser)
                    .build();

            verificationtokenrepo.save(tokenEntity);
            emailservice.sendVerificationEmail(
                    saveduser.getEmail(),
                    verificationToken
            );


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
        Userentity foundUser = user.get();

        if (!passwordEncoder.matches(
                request.getPassword(),
                foundUser.getPassword())) {

            throw new RuntimeException("Invalid email or password");
        }

        if (!foundUser.is_verfied()) {
            throw new RuntimeException("Please verify your email first");
        }

        String token = jwtservice.generateToken(
                foundUser.getEmail()
        );

        Loginresponsedto response = Loginresponsedto.builder()
                .token(token)
                .build();

        return response;

    }

    @Override
    public void verifyEmail(String token) {


        Optional<VerificationTokenEntity> verificationToken =
                verificationtokenrepo.findByToken(token);

        if (verificationToken.isEmpty()){
            throw new RuntimeException("Invalid verification token");
        }


        VerificationTokenEntity tokenEntity = verificationToken.get();

        if (tokenEntity.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Verification token expired");
        }


        Userentity user = tokenEntity.getUser();

        user.set_verfied(true);

        userrepo.save(user);

        verificationtokenrepo.delete(tokenEntity);

    }
}
