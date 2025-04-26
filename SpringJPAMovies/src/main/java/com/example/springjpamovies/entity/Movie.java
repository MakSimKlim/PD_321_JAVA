package com.example.springjpamovies.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Entity
@Table(name="Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id", nullable = false)
    private Integer id;

    @Column(name="title", nullable = false, length = 150)
    @Nationalized
    private String title;

    @Column(name="release_date")
    private LocalDate releaseDate;

    //@Column(name="director", nullable = false, length = 150)
    //@ForeignKey(name = "FK_Movies_Directors", foreignKeyDefinition = Director)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="director", nullable = false)
    private Director director;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
