package com.example.tmdbproyectofinal.TvMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tmdbproyectofinal.Adapters.MovieAdapter;
import com.example.tmdbproyectofinal.Adapters.SeasonAdapter;
import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Episodes;
import com.example.tmdbproyectofinal.Models.Movies;
import com.example.tmdbproyectofinal.MoviesMenus.IndividualMovie;
import com.example.tmdbproyectofinal.MoviesMenus.PopularMovies;
import com.example.tmdbproyectofinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesEpisodes extends AppCompatActivity {
    private String id;
    private String seasonNumber;
    private Episodes episodesFromList;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_episodes);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        seasonNumber = intent.getStringExtra("seasonNumber");
        listview = findViewById(R.id.lstSeasonEpisodes);
        getEpisodesList(id, seasonNumber);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Intent intentid = getIntent();
                String idintent = intentid.getStringExtra("id");
                String numberintent = intentid.getStringExtra("seasonNumber");

                Intent intent = new Intent(SeriesEpisodes.this, EpisodeDetails.class);
                intent.putExtra("id", idintent);
                intent.putExtra("seasonNumber", numberintent);
                intent.putExtra("episodeNumber", episodesFromList.getEpisodeList().get(position).getNumberEpisode());
                startActivity(intent);

            }
        });;
    }

    private void getEpisodesList(String id, String seasonNumber) {
        Call<Episodes> call = RetrofitClient.getInstance().getMyApi().getEpisodeList(id, seasonNumber);
        call.enqueue(new Callback<Episodes>() {
            @Override
            public void onResponse(Call<Episodes> call, Response<Episodes> response) {
                episodesFromList = response.body();
                SeasonAdapter adapterSeason = new SeasonAdapter(SeriesEpisodes.this, episodesFromList);
                listview.setAdapter(adapterSeason);
            }

            @Override
            public void onFailure(Call<Episodes> call, Throwable t) {
                Toast.makeText(SeriesEpisodes.this, "Hubo un error. No se puede mostrar la lista.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}