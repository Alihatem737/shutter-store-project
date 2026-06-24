package com.shutterstore.security;


import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.Jwts;


@Service
public class Jwtservice {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String email){

        Date now = new Date();


        //DATE NOW WITH millisecond
        Date expiration = new Date(
                System.currentTimeMillis() + 1000 * 60 * 60 * 24
        );

        Key key = new SecretKeySpec(
                secretKey.getBytes(StandardCharsets.UTF_8),
                SignatureAlgorithm.HS256.getJcaName()
        );
        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(key)
                .compact();

    }



    public String extractEmail(String token) {

        Key key = new SecretKeySpec(
                secretKey.getBytes(StandardCharsets.UTF_8),
                SignatureAlgorithm.HS256.getJcaName()
        );

        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }



    public boolean isTokenValid(String token){

        try {
            Key key = new SecretKeySpec(
                    secretKey.getBytes(StandardCharsets.UTF_8),
                    SignatureAlgorithm.HS256.getJcaName()
            );


            Jwts.parser()
                    .verifyWith((javax.crypto.SecretKey) key)
                    .build()
                    .parseSignedClaims(token);

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
