package com.example.tmdbproyectofinal.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Episodes {

    @SerializedName("episodes")
    List<Episode> episodeList;

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }
}
