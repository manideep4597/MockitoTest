package com.stackroute.movie.services;

import com.stackroute.movie.exceptions.MovieAlreadyExistsException;
import com.stackroute.movie.exceptions.MovieNotFoundException;
import com.stackroute.movie.exceptions.NullDetailsException;
import com.stackroute.movie.domain.Movie;

import java.util.List;

public interface MovieServices {
    public Movie addMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies() throws NullDetailsException;
    public Movie updateMovie(String comment , int id) throws  MovieNotFoundException;
    public  boolean deleteMovie(int id) throws MovieNotFoundException;
    public Movie getByMovieId(int id) throws MovieNotFoundException;
    public List<Movie> getMovieByName(String movietitle) throws MovieNotFoundException;
}
