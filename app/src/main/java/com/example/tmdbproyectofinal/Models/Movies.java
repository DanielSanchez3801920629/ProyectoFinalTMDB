package com.example.tmdbproyectofinal.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {
    @SerializedName("results")
    List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
