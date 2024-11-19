package com.lentra.BookMyShowClone.controller;

import com.lentra.BookMyShowClone.entity.Response;
import com.lentra.BookMyShowClone.entity.Users;
import com.lentra.BookMyShowClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class UserContoller {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response> register(@RequestBody Users user){

        userService.registerUser(user);

        return null;
    }
}
