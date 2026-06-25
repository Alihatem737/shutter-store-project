package com.shutterstore.services.impl;


import com.shutterstore.services.Emailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Emailserviceimpl implements Emailservice {


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendVerificationEmail(String to, String token) {


        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);

        message.setSubject("Verify Your Email - ShutterStore");


        String verificationLink =
                "http://localhost:8080/auth/verify?token=" + token;


        message.setText(
                "Welcome to ShutterStore!\n\n" +
                        "Click the link below to verify your email:\n\n" +
                        verificationLink
        );


        javaMailSender.send(message);

    }
}
