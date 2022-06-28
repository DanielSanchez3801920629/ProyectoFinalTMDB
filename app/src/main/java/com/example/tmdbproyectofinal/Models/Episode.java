package com.example.tmdbproyectofinal.Models;

import com.google.gson.annotations.SerializedName;

public class Episode {
    @SerializedName("id")
    String idEpisode;

    @SerializedName("name")
    String nameEpisode;

    @SerializedName("overview")
    String overviewEpisode;

    @SerializedName("still_path")
    String stillEpisode;

    @SerializedName("air_date")
    String airDateEpisode;

    @SerializedName("episode_number")
    String numberEpisode;

    public String getIdEpisode() {
        return idEpisode;
    }

    public void setIdEpisode(String idEpisode) {
        this.idEpisode = idEpisode;
    }

    public String getNameEpisode() {
        return nameEpisode;
    }

    public void setNameEpisode(String nameEpisode) {
        this.nameEpisode = nameEpisode;
    }

    public String getOverviewEpisode() {
        return overviewEpisode;
    }

    public void setOverviewEpisode(String overviewEpisode) {
        this.overviewEpisode = overviewEpisode;
    }

    public String getStillEpisode() {
        return stillEpisode;
    }

    public void setStillEpisode(String stillEpisode) {
        this.stillEpisode = stillEpisode;
    }

    public String getAirDateEpisode() {
        return airDateEpisode;
    }

    public void setAirDateEpisode(String airDateEpisode) {
        this.airDateEpisode = airDateEpisode;
    }

    public String getNumberEpisode() {
        return numberEpisode;
    }

    public void setNumberEpisode(String numberEpisode) {
        this.numberEpisode = numberEpisode;
    }
}
