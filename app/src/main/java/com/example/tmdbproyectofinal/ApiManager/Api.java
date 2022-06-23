package com.example.tmdbproyectofinal.ApiManager;

import com.example.tmdbproyectofinal.Models.Movie;
import com.example.tmdbproyectofinal.Models.Movies;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Api {
    String BASE_URL = "https://api.themoviedb.org/3/";
    String API_KEY = "?api_key=bd7219473dd403ac565d81c5e4f8544f&language=en-US&page=1";

    @GET("movie/popular"+API_KEY)
    Call<Movies> getPopularMovies();

    @GET("movie/{id}"+API_KEY)
    Call<Movie> getMovie(@Path("id") String id);
}
