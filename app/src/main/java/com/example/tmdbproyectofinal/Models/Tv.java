package com.example.tmdbproyectofinal.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tv {
    @SerializedName("results")
    List<Series> tvList;

    public List<Series> getTvList() {
        return tvList;
    }

    public void setTvList(List<Series> tvList) {
        this.tvList = tvList;
    }
}
