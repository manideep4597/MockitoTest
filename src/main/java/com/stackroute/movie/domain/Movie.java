package com.stackroute.movie.domain;

;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Movie {
    @Id
    private int imdbId;

    private String movieTitle;
    private String posterUrl;
    private  double rating;
    private int yearOfRelease;
    private  String comment;

    public Movie(int imdbId, String movieTitle, String posterUrl, double rating, int yearOfRelease, String comment) {
        this.imdbId = imdbId;
        this.movieTitle = movieTitle;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
        this.comment = comment;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Movie() {
    }



    public int getImbdId() {
        return imdbId;
    }

    public void setImbdId(int imbdId) {
        this.imdbId = imbdId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "imdbId=" + imdbId +
                ", movieTitle='" + movieTitle + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", rating=" + rating +
                ", yearOfRelease=" + yearOfRelease +
                ", comment='" + comment + '\'' +
                '}';
    }
}
