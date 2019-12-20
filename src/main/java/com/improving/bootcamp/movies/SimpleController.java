package com.improving.bootcamp.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

@Controller
public class SimpleController {

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping(path="/movies/sorted-asc")
    public ResponseEntity<List<Movie>> getMoviesSortedByRatingAsc() {
        return new ResponseEntity<>((movieRepo.findByOrderByRatingAsc()), HttpStatus.OK);
    }

    @GetMapping(path="/movies/sorted-desc")
    public ResponseEntity<List<Movie>> getMoviesSortedByRatingDesc() {
        return new ResponseEntity<>((movieRepo.findByOrderByRatingDesc()), HttpStatus.OK);
    }

    @GetMapping(path="/movies/sorted-title-asc")
    public ResponseEntity<List<Movie>> getMoviesSortedByTitleAsc() {
        return new ResponseEntity<>((movieRepo.findByOrderByTitleAsc()), HttpStatus.OK);
    }

    @GetMapping(path="/movies/sorted-title-desc")
    public ResponseEntity<List<Movie>> getMoviesSortedByTitleDesc() {
        return new ResponseEntity<>((movieRepo.findByOrderByTitleDesc()), HttpStatus.OK);
    }


    @GetMapping(path = "/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        LocalDateTime currentDate = LocalDateTime.now();
        return new ResponseEntity<>((movieRepo.findAllByStartTimeLessThanEqualAndEndTimeGreaterThan(currentDate, currentDate)), HttpStatus.OK);
    }

    @GetMapping(path = "/movies/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Integer id) {
        return new ResponseEntity<>((movieRepo.findById(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/movies")
    public ResponseEntity<Optional<Movie>> addMovie(@RequestBody Movie movie){
        boolean movieAlreadyInTable = movieRepo.existsByTitle(movie.getTitle());
        if(movieAlreadyInTable){
            System.out.println("Movie already in DB");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else {
            //how do I get this to match format in DB???
            LocalDateTime startDate = LocalDateTime.now(ZoneId.of("America/Chicago"));
            movie.setStartTime(startDate);

            LocalDateTime endDate = LocalDateTime.of(2035, 12, 31, 12, 00, 00);
            movie.setEndTime(endDate);
            movieRepo.save(movie);
            return new ResponseEntity<>((Optional.of(movie)), HttpStatus.OK);
        }
    }

    @PutMapping(path="/movies/{id}")
    public ResponseEntity<Optional<Movie>> updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
        Optional<Movie> movieOptional = movieRepo.findById(id);
        if(!movieOptional.isPresent()){
            System.out.println("Unable to update because, no existing movie found");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        else{
            movieRepo.save(movie);
            System.out.println("Movie updated!");
            return new ResponseEntity<>(movieOptional, HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/movies/{id}")
    public ResponseEntity<Optional<Movie>> deleteMovie(@PathVariable Integer id) {
        Optional<Movie> movieToDelete = movieRepo.findById(id);

        if(movieToDelete.isPresent()){
            //is there better way to do this other than setter?
            movieToDelete.get().setIsDeleted(true);
            movieRepo.save(movieToDelete.get());
            System.out.println("movie with id " + id + " deleted.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        else{
            System.out.println("Error: No movie with id " + id + " found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}