package com.improving.bootcamp.movies;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {

    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Integer integer);

    @Override
    Movie save(Movie movie);

    @Override
    void deleteById(Integer integer);
}

