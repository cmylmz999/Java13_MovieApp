package com.bilgeadam.controller;

import com.bilgeadam.entity.MovieComment;
import com.bilgeadam.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie-comment")
@RequiredArgsConstructor
public class MovieCommentController {

    private final MovieCommentService movieCommentService;

    @GetMapping("/get-all-by-movie-id")
    public ResponseEntity<List<MovieComment>> getAllByMovieId(Long id){
        return ResponseEntity.ok(movieCommentService.findAllByMovieId(id));
    }

    @GetMapping("/get-all-by-movie-id-and-date-between")
    public ResponseEntity<List<MovieComment>> getAllByMovieIdAndDateBetween(Long id, LocalDate datemin, LocalDate datemax){
        return ResponseEntity.ok(movieCommentService.findAllByMovieIdIsAndDateBetween(id, datemin, datemax));
    }

    @GetMapping("/get-all-by-content-length-greater-than")
    public ResponseEntity<List<MovieComment>> getAllByContentLengthGreaterThan(){
        return ResponseEntity.ok(movieCommentService.findMovieCommentsByContentLengthGreaterThan(20));
    }
}
