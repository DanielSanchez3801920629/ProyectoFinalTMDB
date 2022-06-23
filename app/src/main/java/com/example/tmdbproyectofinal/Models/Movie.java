package com.example.tmdbproyectofinal.Models;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    String idMovie;

    @SerializedName("title")
    String titleMovie;

    @SerializedName("overview")
    String overviewMovie;

    @SerializedName("poster_path")
    String posterMovie;

    @SerializedName("release_date")
    String releaseMovie;

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getOverviewMovie() {
        return overviewMovie;
    }

    public void setOverviewMovie(String overviewMovie) {
        this.overviewMovie = overviewMovie;
    }

    public String getPosterMovie() {
        return posterMovie;
    }

    public void setPosterMovie(String posterMovie) {
        this.posterMovie = posterMovie;
    }

    public String getReleaseMovie() {
        return releaseMovie;
    }

    public void setReleaseMovie(String releaseMovie) {
        this.releaseMovie = releaseMovie;
    }

}
