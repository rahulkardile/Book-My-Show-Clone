package com.lentra.BookMyShowClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 50)
    private String genre;

    @Column(nullable = false)
    private Duration duration;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String language;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();
}
