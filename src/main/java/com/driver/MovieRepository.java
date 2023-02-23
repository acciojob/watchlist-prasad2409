package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MovieRepository {
    Map<String,Movie> movieDB = new HashMap<>();
    Map<String,Director> directorDB = new HashMap<>();
    Map<String, List<String>> dirMovieDB = new HashMap<>();

    public String addMovie(Movie movie){
        movieDB.put(movie.getName(), movie);
        return "Success";
    }
    public void addDirector(Director director){
        directorDB.put(director.getName(),director);
    }
    public String addMovieDirectorPair(String movieName,String directorName){
        if(movieDB.containsKey(movieName) && directorDB.containsKey(directorName)){
            if(dirMovieDB.containsKey(directorName)){
                dirMovieDB.get(directorName).add(movieName);
            }
            else {
                List<String> movies = new ArrayList<>();
                movies.add(movieName);
                dirMovieDB.put(directorName,movies);
            }
        }
        return "success";
    }

    public Movie getMovieByName(String name){
        if(movieDB.containsKey(name)){
            return movieDB.get(name);
        }
        return null;
    }

    public Director getDirectorByName(String name){
        if(directorDB.containsKey(name)){
            return directorDB.get(name);
        }
        return null;
    }
    public List<String> getMoviesByDirectorName(String name){
        List<String> movies = new ArrayList<>();
        if(dirMovieDB.containsKey(name)){
            movies = dirMovieDB.get(name);
        }
        return movies;
    }
    public List<String> findAllMovies(){
        List<String> movies = new ArrayList<>();
        for(String s : movieDB.keySet()){
            movies.add(s);
        }
        return movies;
    }
    public void deleteDirectorByName(String name){
        if(directorDB.containsKey(name)) {
            if (dirMovieDB.containsKey(name)) {
                List<String> list = new ArrayList<>();
                list = dirMovieDB.get(name);
                for (String s : list) {
                    list.remove(s);
                }
                dirMovieDB.remove(name);
            }
            directorDB.remove(name);
        }
    }
    public void deleteAllDirectors(){
        ArrayList<String> list = new ArrayList<>();
        for(String s: dirMovieDB.keySet()){
            for(String m : dirMovieDB.get(s)){
                list.add(m);
            }
        }
        for(String i : list) movieDB.remove(i);
    }
}
