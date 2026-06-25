package com.shutterstore.services;

public interface Emailservice {


    void sendVerificationEmail(String to, String token);

}
