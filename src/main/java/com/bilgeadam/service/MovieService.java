package com.bilgeadam.service;

import com.bilgeadam.entity.Movie;
import com.bilgeadam.repository.MovieRepository;
import com.bilgeadam.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MovieService implements ICrudService<Movie, Long> {
    private final MovieRepository movieRepository;
    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return null;
    }

    @Override
    public Movie deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }
    public List<Movie> findAllByRatingIsGreaterThan(Double rating){
        return movieRepository.findAllByRatingIsGreaterThan(rating);
    }

    public List<Movie> findAllByPremieredBefore(String date){
        if(isValidDateFormat(date)){
            return movieRepository.findAllByPremieredBefore(LocalDate.parse(date));
        }else{
            throw new RuntimeException("Gecerli bir tarih girmediniz.");
        }

    }
    public boolean isValidDateFormat(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Movie> findAllByRatingBetween(){
        return movieRepository.findAllByRatingBetween(7d, 9d);
    }
}
