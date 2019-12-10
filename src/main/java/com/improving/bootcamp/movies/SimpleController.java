package com.improving.bootcamp.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SimpleController {

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping(path = "/movies")
    public @ResponseBody List<Movie> getMovies() {

        return (List<Movie>) movieRepo.findAll();
    }

    @GetMapping(path = "/movie/{id}")
    public @ResponseBody Optional<Movie> getMovieById(@PathVariable Integer id) {

        return movieRepo.findById(id);
    }

    @PostMapping(path = "/movies")
    public void addMovie(@RequestBody Movie movie){
        movieRepo.save(movie);
    }

    @DeleteMapping(path = "/movie/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieRepo.deleteById(id);
    }
}