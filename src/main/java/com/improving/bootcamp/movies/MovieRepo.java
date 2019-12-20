package com.improving.bootcamp.movies;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer>  {

    List<Movie> findAllByStartTimeLessThanEqualAndEndTimeGreaterThan(LocalDateTime currentDate, LocalDateTime currentDate2);

    @Override
    Optional<Movie> findById(Integer integer);

    Optional<Movie> findByTitle(String title);

    List<Movie> findByOrderByRatingAsc();

    List<Movie> findByOrderByRatingDesc();

    List<Movie> findByOrderByTitleDesc();

    List<Movie> findByOrderByTitleAsc();

    boolean existsByTitle(String title);

    @Override
    Movie save(Movie movie);

    @Override
    void deleteById(Integer integer);


}

