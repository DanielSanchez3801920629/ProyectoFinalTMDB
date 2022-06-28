package com.example.tmdbproyectofinal.Models;

import com.google.gson.annotations.SerializedName;

public class Series {
    @SerializedName("id")
    String idSeries;
    @SerializedName("name")
    String nameSeries;
    @SerializedName("overview")
    String overviewSeries;
    @SerializedName("first_air_date")
    String firstAirTv;
    @SerializedName("poster_path")
    String posterSeries;
    @SerializedName("number_of_seasons")
    String numberOfSeasons;

    public String getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(String numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(String idSeries) {
        this.idSeries = idSeries;
    }

    public String getFirstAirTv() {
        return firstAirTv;
    }
    public void setFirstAirTv(String firstAirTv) {
        this.firstAirTv = firstAirTv;
    }

    public String getNameSeries() {
        return nameSeries;
    }

    public void setNameSeries(String nameSeries) {
        this.nameSeries = nameSeries;
    }

    public String getOverviewSeries() {
        return overviewSeries;
    }

    public void setOverviewSeries(String overviewSeries) {
        this.overviewSeries = overviewSeries;
    }

    public String getPosterSeries() {
        return posterSeries;
    }

    public void setPosterSeries(String posterSeries) {
        this.posterSeries = posterSeries;
    }
}
