package com.stackroute.movie.controller;

import com.stackroute.movie.exceptions.MovieNotFoundException;
import com.stackroute.movie.exceptions.NullDetailsException;
import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {

    private MovieServices movieServices;
    // autowiring via constructor
    @Autowired
    public MovieController( MovieServices movieServices) {
        this.movieServices =movieServices;
    }
    public boolean isParsable(String id){
        try {
            int i=Integer.parseInt(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    @PostMapping("add")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try
        {       Movie savedMovie =movieServices.addMovie(movie);
            responseEntity = new ResponseEntity<Movie>(savedMovie, HttpStatus.CREATED);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        }

        return responseEntity;

    }
    @GetMapping()
    public ResponseEntity<?> getallMovies(){
        ResponseEntity responseEntity ;
        try{
            responseEntity = new ResponseEntity<List<Movie>>(movieServices.getAllMovies(),HttpStatus.OK);
        }
        catch (NullDetailsException ex){
            responseEntity =new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("{id}")
    public ResponseEntity<?>updateMovie(@RequestBody String string,@PathVariable("id") int id){
        ResponseEntity responseEntity;
        try{

            responseEntity = new ResponseEntity<Movie>( movieServices.updateMovie(string,id),HttpStatus.OK);
        }
        catch (MovieNotFoundException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //@PutMapping("movie/delete/{id}")
    @DeleteMapping("{id}")
    public  ResponseEntity<?> deleteMovie(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        try{
            movieServices.deleteMovie(id);
            responseEntity= new ResponseEntity("deleted successfully",HttpStatus.OK);
        }
        catch (MovieNotFoundException ex){
            responseEntity =new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getbyMovieId(@PathVariable("id") String id){
        ResponseEntity responseEntity ;
        try{
            if(isParsable(id)) {
                int i = Integer.parseInt(id);
                responseEntity = new ResponseEntity<Movie>(movieServices.getByMovieId(i), HttpStatus.OK);
            }
            else {
                responseEntity = new ResponseEntity<List<Movie>>(movieServices.getMovieByName(id), HttpStatus.OK);
            }
        }
        catch (Exception ex){
            responseEntity =new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
