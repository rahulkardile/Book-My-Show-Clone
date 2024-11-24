package com.lentra.BookMyShowClone.controller;

import com.lentra.BookMyShowClone.entity.Movie;
import com.lentra.BookMyShowClone.entity.Response;
import com.lentra.BookMyShowClone.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class MovieController {

    @Autowired
    private MoviesService service;

    @Autowired
    private Response response;

    @PostMapping("/create")
    public ResponseEntity< ? > createMovie( @RequestBody Movie movies ) {
        Optional< Movie > movies1 = Optional.ofNullable( service.createMovie( movies ) );
        return new ResponseEntity<>( movies1 , HttpStatus.CREATED );
    }

    @PostMapping("/get/{id}")
    public ResponseEntity< ? > getMovie( @PathVariable int id ) {
        Optional< Movie > movies1 = service.GetById( id );
        if (movies1.isEmpty()) {
            response.setMessage("Movie Not Found!");
            response.setSuccess( false );
            response.setStatusCode( 404 );
            return new ResponseEntity<>( response , HttpStatus.NOT_FOUND );
        } else {
            return ResponseEntity.ok(movies1);
        }
    }


}
