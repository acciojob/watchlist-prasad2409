package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService service;
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        service.addMovie(movie);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        service.addDirector(director);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("dirName") String driName){
        service.addMovieDirectorPair(movieName,driName);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        Movie movie = service.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String dir){
        Director director = service.getDirectorByName(dir);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }
    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable ("director") String dir){
        List<String> l = service.getMoviesByDirectorName(dir);
        return new ResponseEntity<>(l,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> l = service.findAllMovies();
        return new ResponseEntity<>(l,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String dir){
        service.deleteDirectorByName(dir);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        service.deleteAllDirectors();
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
