package com.example.tmdbproyectofinal.TvMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tmdbproyectofinal.Models.Series;
import com.example.tmdbproyectofinal.MoviesMenus.IndividualMovie;
import com.example.tmdbproyectofinal.MoviesMenus.PopularMovies;
import com.example.tmdbproyectofinal.R;

import java.util.ArrayList;
import java.util.List;

public class SeriesSeasons extends AppCompatActivity implements View.OnClickListener {
    private String id;
    private String seasonNumberIntent;
    private String numberOfSeasonsString;
    private int seasonNumbers;
    private ListView seasonsListView;
    private List<String> seasonsList = new ArrayList<>();
    private ArrayAdapter<String> seasonsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_seasons);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        numberOfSeasonsString = intent.getStringExtra("numberOfSeasons");
        seasonNumbers = Integer.parseInt(numberOfSeasonsString);


        for (int i = 0; i < seasonNumbers; i++) {
            int seasonName = i+1;
            seasonsList.add(String.valueOf(seasonName));
        }

        seasonsListView = findViewById(R.id.lstSeriesSeasons);
        seasonsListAdapter = new ArrayAdapter<>(this, R.layout.item_seasons, R.id.btnSeasonNumber, seasonsList);
        seasonsListView.setAdapter(seasonsListAdapter);

    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        Intent intentId = getIntent();
        seasonNumberIntent = b.getText().toString();
        id = intentId.getStringExtra("id");


        Intent intent = new Intent(SeriesSeasons.this, SeriesEpisodes.class);
        intent.putExtra("id", id);
        intent.putExtra("seasonNumber", seasonNumberIntent);

        startActivity(intent);
    }
}