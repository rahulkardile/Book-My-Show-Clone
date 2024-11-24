package com.lentra.BookMyShowClone.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    String secret = "";

    JWTService() throws NoSuchAlgorithmException {
        KeyGenerator genKey = KeyGenerator.getInstance("HmacSHA256");
        SecretKey key = genKey.generateKey();
        secret = Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public String generateToken(String username){

        Map<String, Object> claims = new HashMap <>(  );

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                .and()
                .signWith(getKey())
                .compact();
    }

    public SecretKey getKey(){
        byte[] getBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(getBytes);
    }

}
