package com.lentra.BookMyShowClone.controller;

import com.lentra.BookMyShowClone.entity.SimpleRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {

    @Autowired
    SimpleRes res;

    @GetMapping
    public ResponseEntity<SimpleRes> Greet() {
        res.setMessage("Hello From Book My Show Server!");
        res.setStatusCode(HttpStatus.OK.value());
        res.setSuccess(true);
        return new ResponseEntity<SimpleRes>(res, HttpStatus.OK);
    }

}
