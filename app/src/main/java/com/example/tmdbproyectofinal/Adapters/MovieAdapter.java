package com.example.tmdbproyectofinal.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmdbproyectofinal.Models.Movie;
import com.example.tmdbproyectofinal.Models.Movies;
import com.example.tmdbproyectofinal.R;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends BaseAdapter {
    protected Activity activity;
    protected Movies myMovies;

    public MovieAdapter(Activity activity, Movies myMovies) {
        this.activity = activity;
        this.myMovies = myMovies;
    }

    @Override
    public int getCount() {
        return myMovies.getMovieList().size();
    }

    @Override
    public Object getItem(int position) {
        return myMovies.getMovieList().get(position);
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
            v = inf.inflate(R.layout.item_movie,null);
        }

        Movie movie = myMovies.getMovieList().get(position);

        ImageView imageMovie = v.findViewById(R.id.imgMovie);
        TextView titleMovie = v.findViewById(R.id.txtTitleMovie);
        TextView overviewMovie = v.findViewById(R.id.txtOverviewMovie);
        TextView releaseMovie = v.findViewById(R.id.txtReleaseMovie);

        titleMovie.setText(movie.getTitleMovie());
        overviewMovie.setText(movie.getOverviewMovie());
        releaseMovie.setText(movie.getReleaseMovie());
        Picasso.get().load("https://image.tmdb.org/t/p/w300"+movie.getPosterMovie()).into(imageMovie);

        return v;
    }
}
