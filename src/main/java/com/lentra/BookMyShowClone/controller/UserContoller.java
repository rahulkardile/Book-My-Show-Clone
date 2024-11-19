package com.lentra.BookMyShowClone.controller;

import com.lentra.BookMyShowClone.entity.Response;
import com.lentra.BookMyShowClone.entity.Users;
import com.lentra.BookMyShowClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class UserContoller {

    @Autowired
    private UserService userService;

    private Response response = new Response(  );

    @PostMapping("/register")
    public ResponseEntity <Response> register(@RequestBody Users user) {
        if (userService.registerUser(user)) {
            response.setMessage("Welcome " + user.getName());
            response.setStatusCode(201);
            response.setSuccess(true);
            return new ResponseEntity <>( response, HttpStatus.CREATED);
        }else{
            response.setMessage("Something went wrong!");
            response.setStatusCode(HttpStatus.CONFLICT.value());
            response.setSuccess(false);
            return new ResponseEntity <>( response, HttpStatus.CONFLICT);
        }
    }
}
