package com.bilgeadam.controller;

import com.bilgeadam.entity.Movie;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/get-all-by-rating-larger-than")
    public ResponseEntity<List<Movie>> getAllByRatingLargerThan(Double rating) {
        return ResponseEntity.ok(movieService.findAllByRatingIsGreaterThan(rating));
    }

    @GetMapping("/get-all-by-premiered-before")
    public ResponseEntity<List<Movie>> getAllByPremieredBefore(String date) {
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(date));
    }

    @GetMapping("/get-all-by-rating-between-7-9")
    public ResponseEntity<List<Movie>> getAllByRatingBetween() {
        return ResponseEntity.ok(movieService.findAllByRatingBetween());
    }


}
