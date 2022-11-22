package com.example.userMovieDemo.domain;

import org.springframework.data.annotation.Id;

public class Movie {
    @Id
    private int movieId;
    private String movieName;
    private int yearOfRealease;
    private String actorName;

    public Movie(){
    }

    public Movie(int movieId, String movieName, int yearOfRealease, String actorName) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.yearOfRealease = yearOfRealease;
        this.actorName = actorName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYearOfRealease() {
        return yearOfRealease;
    }

    public void setYearOfRealease(int yearOfRealease) {
        this.yearOfRealease = yearOfRealease;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", yearOfRealease=" + yearOfRealease +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
