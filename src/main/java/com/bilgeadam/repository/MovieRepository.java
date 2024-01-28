package com.bilgeadam.repository;

import com.bilgeadam.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByRatingIsGreaterThan(Double rating);
    List<Movie> findAllByPremieredBefore(LocalDate date);

    List<Movie> findAllByRatingBetween(Double min, Double max);

}
