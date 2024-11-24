package com.lentra.BookMyShowClone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String movieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String cast;

    @Column(nullable = false)
    private String poster;

    @Column(nullable = false)
    private String movieCreator;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String genre;

}

//movie_Id
//        Title
//Cast
//        creator
//genre
//        language
//description
//        poster
//duration
//        created_at
