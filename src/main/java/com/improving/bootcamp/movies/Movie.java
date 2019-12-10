package com.improving.bootcamp.movies;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "movie_description")
    private String movieDescription;

    @Column(name = "length")
    private Integer length;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private String rating;

    @Column(name="poster_url")
    private String posterUrl;

    public Movie(Integer movieId, String title, String movieDescription, Integer length, String genre, String rating, String posterUrl) {
        this.movieId = movieId;
        this.title = title;
        this.movieDescription = movieDescription;
        this.length = length;
        this.genre = genre;
        this.rating = rating;
        this.posterUrl = posterUrl;
    }

    public Movie(){

    }


    public Integer getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public Integer getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
