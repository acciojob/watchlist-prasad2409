package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;
    public void addMovie(Movie movie){
        repository.addMovie(movie);
    }
    public void addDirector(Director director){
        repository.addDirector(director);
    }
    public void addMovieDirectorPair(String movieName,String dirName){
        repository.addMovieDirectorPair(movieName,dirName);
    }
    public Movie getMovieByName(String name){
        return repository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return repository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String name){
        return repository.getMoviesByDirectorName(name);
    }
    public List<String> findAllMovies(){
        return repository.findAllMovies();
    }
    public void deleteDirectorByName(String name){
        repository.deleteDirectorByName(name);
    }
    public void deleteAllDirectors(){
        repository.deleteAllDirectors();
    }
}
