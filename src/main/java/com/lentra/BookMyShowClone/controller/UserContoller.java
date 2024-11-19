package com.lentra.BookMyShowClone.controller;

import com.lentra.BookMyShowClone.entity.Response;
import com.lentra.BookMyShowClone.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class UserContoller {

    @PostMapping
    public ResponseEntity<Response> register(@RequestBody Users user){

        return null;
    }
}
