package com.example.tmdbproyectofinal.ApiManager;

import com.example.tmdbproyectofinal.Models.Episode;
import com.example.tmdbproyectofinal.Models.Episodes;
import com.example.tmdbproyectofinal.Models.Movie;
import com.example.tmdbproyectofinal.Models.Movies;
import com.example.tmdbproyectofinal.Models.Series;
import com.example.tmdbproyectofinal.Models.Tv;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Api {
    String BASE_URL = "https://api.themoviedb.org/3/";
    String API_KEY = "?api_key=bd7219473dd403ac565d81c5e4f8544f&language=en-US&page=1";

    //Movie Endpoints
    @GET("movie/popular"+API_KEY)
    Call<Movies> getPopularMovies();
    @GET("movie/now_playing"+API_KEY)
    Call<Movies> getNowPlayingMovies();
    @GET("movie/top_rated"+API_KEY)
    Call<Movies> getTopRatedMovies();
    @GET("movie/upcoming"+API_KEY)
    Call<Movies> getUpcomingMovies();
    @GET("movie/{id}/similar"+API_KEY)
    Call<Movies> getSimilarMovies(@Path("id") String id);
    @GET("movie/{id}"+API_KEY)
    Call<Movie> getMovie(@Path("id") String id);

    //TV Endpoints
    @GET("tv/popular"+API_KEY)
    Call<Tv> getPopularTv();
    @GET("tv/on_the_air"+API_KEY)
    Call<Tv> getOnTheAirTv();
    @GET("tv/top_rated"+API_KEY)
    Call<Tv> getTopRatedTv();
    @GET("tv/airing_today"+API_KEY)
    Call<Tv> getAiringTodayTv();
    @GET("tv/{id}/season/{seasonNumber}"+API_KEY)
    Call<Episodes> getEpisodeList(@Path("id") String id, @Path("seasonNumber") String seasonNumber);
    @GET("tv/{id}/season/{seasonNumber}/episode/{episodeNumber}"+API_KEY)
    Call<Episode> getEpisode(@Path("id") String id, @Path("seasonNumber") String seasonNumber, @Path("episodeNumber") String episodeNumber);
    @GET("tv/{id}"+API_KEY)
    Call<Series> getTv(@Path("id") String id);
}
