package com.bilgeadam.repository;

import com.bilgeadam.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {

    List<MovieComment> findAllByMovieId(Long id);
    List<MovieComment> findAllByMovieIdIsAndDateBetween(Long id, LocalDate datemin, LocalDate datemax);


    @Query("SELECT mc FROM MovieComment mc WHERE LENGTH(mc.content) > :length")
    List<MovieComment> findMovieCommentsByContentLengthGreaterThan(@Param("length") int length);
}
