package com.improving.bootcamp.movies;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "movies")
@Where(clause = "is_deleted = false")
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
    private Integer rating;

    @Column(name="poster_url")
    private String posterUrl;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name="start_time")
    private LocalDateTime startTime;

    @Column(name="end_time")
    private LocalDateTime endTime;


    public Movie(Integer movieId, String title, String movieDescription, Integer length, String genre, Integer rating, String posterUrl, boolean isDeleted) {
        this.movieId = movieId;
        this.title = title;
        this.movieDescription = movieDescription;
        this.length = length;
        this.genre = genre;
        this.rating = rating;
        this.posterUrl = posterUrl;
        this.isDeleted = isDeleted;
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

    public Integer getRating() {
        return rating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    //is there better way to do this other than setter
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
