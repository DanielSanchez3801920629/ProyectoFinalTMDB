package com.example.tmdbproyectofinal.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmdbproyectofinal.Models.Episode;
import com.example.tmdbproyectofinal.Models.Episodes;
import com.example.tmdbproyectofinal.R;
import com.squareup.picasso.Picasso;

public class SeasonAdapter extends BaseAdapter {

    protected Activity activity;
    protected Episodes myEpisodes;

    public SeasonAdapter(Activity activity, Episodes myEpisodes) {
        this.activity = activity;
        this.myEpisodes = myEpisodes;
    }

    @Override
    public int getCount() {
        return myEpisodes.getEpisodeList().size();
    }

    @Override
    public Object getItem(int position) {
        return myEpisodes.getEpisodeList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_episodes,null);
        }

        Episode episodes = myEpisodes.getEpisodeList().get(position);

        ImageView episodeStill = v.findViewById(R.id.imgEpisodeStill);
        TextView nameEpisode = v.findViewById(R.id.txtEpisodeName);
        TextView overviewEpisode = v.findViewById(R.id.txtOverviewEpisode);
        TextView airdateEpisode = v.findViewById(R.id.txtAirDateEpisode);

        nameEpisode.setText(episodes.getNameEpisode());
        overviewEpisode.setText(episodes.getOverviewEpisode());
        airdateEpisode.setText(episodes.getAirDateEpisode());
        Picasso.get().load("https://image.tmdb.org/t/p/w300"+episodes.getStillEpisode()).into(episodeStill);

        return v;
    }
}
