package com.stackroute.movie.repository;


import com.stackroute.movie.domain.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositryTest {
        @Autowired
    MovieRepository movieRepository;
    Movie movie;
    @Before
    public void setUp() {
        movie = new Movie(1,"bean","english",(double) 5.0,2018,"done");
    }
    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getImbdId()).get();
        Assert.assertEquals(1,fetchMovie.getImbdId());

    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(2,"race","hindi",(double) 4,2018,"save");
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getImbdId()).get();
        Assert.assertNotEquals(testMovie.getImbdId(),fetchMovie.getImbdId());

    }

    @Test
    public void testGetAllUser(){
        Movie m = new Movie(2,"race","hindi",(double) 4,2018,"save");
        Movie m1 = new Movie(3,"bean","english",(double) 5.0,2018,"done");
        movieRepository.save(m);
        movieRepository.save(m1);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals(2,list.get(0).getImbdId());




    }
}

