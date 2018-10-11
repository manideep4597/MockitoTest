package com.stackroute.movie.repository;


import com.stackroute.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
       // @Query(value = "select * from moviedetails",nativeQuery = true)
        //public List<Movie> getAllMovies();
      @Query(value = "select * from MOVIEDETAILS m where m.IMDB_ID = :id",nativeQuery = true)
       public Movie findByimdbId(@Param("id") int id);
       @Query(value = "select * from MOVIEDETAILS m where m.MOVIE_TITLE = :movietitle",nativeQuery = true)
        public List<Movie> findBymovieTitle(@Param("movietitle") String  movietitle);

        }
