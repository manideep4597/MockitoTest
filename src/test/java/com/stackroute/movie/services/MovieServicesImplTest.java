package com.stackroute.movie.services;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exceptions.NullDetailsException;
import com.stackroute.movie.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieServicesImplTest {
    Movie movie;
    @Mock
    private MovieRepository movieRepository;
    @InjectMocks
     private MovieServicesImpl movieServices;

    List<Movie> list = null;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        movie = new Movie(1,"bean","english",(double) 5.0,2018,"done");
    }
    @Test
    public void saveMovieTest() throws Exception{
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Movie savedMovies = movieServices.addMovie(movie);
        Assert.assertEquals(movie,savedMovies);
        verify(movieRepository,times(1)).save(movie);
    }
    @Test
    public void getAllUser() throws NullDetailsException {
        movieRepository.save(movie);
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> moviesList = movieServices.getAllMovies();
        Assert.assertEquals(list,moviesList);
        verify(movieRepository,times(1)).findAll();
    }
    @Test
    public void searchById() throws Exception{
        try {
            Movie movies1 = new Movie(4,"run-fun","https://www.bookmyshow.com",3.8,2016,"love story");
            when(movieRepository.save(movies1)).thenReturn(movies1);
            Movie savedMovies = movieServices.addMovie(movies1);
            Optional<Movie> returnMovie=Optional.empty();
            when(movieRepository.findById(any())).thenReturn(returnMovie);
            Movie returnServiceMovie = movieServices.getByMovieId(movies1.getImbdId());
            Assert.assertEquals(returnMovie.toString(),returnServiceMovie.toString());

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }

}

