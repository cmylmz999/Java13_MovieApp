package com.bilgeadam.service;

import com.bilgeadam.entity.MovieComment;
import com.bilgeadam.repository.MovieCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCommentService {
    private final MovieCommentRepository movieCommentRepository;

    public List<MovieComment> findAllByMovieId(Long movieId){
        return movieCommentRepository.findAllByMovieId(movieId);
    }

    public List<MovieComment> findAllByMovieIdIsAndDateBetween(Long id, LocalDate datemin, LocalDate datemax){
        return movieCommentRepository.findAllByMovieIdIsAndDateBetween(id, datemin, datemax);
    }
    public List<MovieComment> findMovieCommentsByContentLengthGreaterThan(int length){
        return movieCommentRepository.findMovieCommentsByContentLengthGreaterThan(length);
    }

}
