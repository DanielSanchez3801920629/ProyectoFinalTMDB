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
import com.example.tmdbproyectofinal.Models.Series;
import com.example.tmdbproyectofinal.Models.Tv;
import com.example.tmdbproyectofinal.R;
import com.squareup.picasso.Picasso;

public class SeriesAdapter extends BaseAdapter {

    protected Activity activity;
    protected Tv myTv;

    public SeriesAdapter(Activity activity, Tv myTv) {
        this.activity = activity;
        this.myTv = myTv;
    }

    @Override
    public int getCount() {
        return myTv.getTvList().size();
    }

    @Override
    public Object getItem(int position) {
        return myTv.getTvList().get(position);
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
            v = inf.inflate(R.layout.item_tv,null);
        }

        Series serie = myTv.getTvList().get(position);

        ImageView imageTv = v.findViewById(R.id.imgTv);
        TextView nameTv = v.findViewById(R.id.txtNameTv);
        TextView overviewTv = v.findViewById(R.id.txtOverviewSeries);
        TextView launchTv = v.findViewById(R.id.txtLaunchDateTv);

        nameTv.setText(serie.getNameSeries());
        overviewTv.setText(serie.getOverviewSeries());
        launchTv.setText(serie.getFirstAirTv());
        Picasso.get().load("https://image.tmdb.org/t/p/w300"+serie.getPosterSeries()).into(imageTv);

        return v;
    }
}
