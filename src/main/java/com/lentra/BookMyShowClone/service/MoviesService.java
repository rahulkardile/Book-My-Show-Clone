package com.lentra.BookMyShowClone.service;

import com.lentra.BookMyShowClone.entity.Movie;
import com.lentra.BookMyShowClone.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepo repo;

    public Movie createMovie( Movie movies ) {
        return repo.save( movies );
    }

    public Optional< Movie > GetById( int id ) {
        Optional< Movie > movies = repo.findById( id );
        return movies;
    }
}
