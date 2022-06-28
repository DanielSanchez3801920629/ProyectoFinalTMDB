package com.example.tmdbproyectofinal.TvMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Episode;
import com.example.tmdbproyectofinal.MoviesMenus.IndividualMovie;
import com.example.tmdbproyectofinal.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeDetails extends AppCompatActivity {
    private String id;
    private String seasonNumber;
    private String episodeNumberV;

    private Episode episodeDetail;
    ImageView episodeStill;
    TextView episodeName;
    TextView episodeOverview;
    TextView episodeAirDate;
    TextView episodeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_details);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        seasonNumber = intent.getStringExtra("seasonNumber");
        episodeNumberV = intent.getStringExtra("episodeNumber");

        episodeStill = findViewById(R.id.imgEpisodeDetails);
        episodeName = findViewById(R.id.txtEpisodeDetailName);
        episodeOverview = findViewById(R.id.txtEpisodeDetailOverview);
        episodeAirDate = findViewById(R.id.txtEpisodeDetailDate);
        episodeNumber = findViewById(R.id.txtEpisodeDetailNumber);

        getEpisodeDetails(id, seasonNumber, episodeNumberV);



    }

    private void getEpisodeDetails(String id, String seasonNumber, String episodeNumberVar) {
        Call<Episode> call = RetrofitClient.getInstance().getMyApi().getEpisode(id, seasonNumber, episodeNumberVar);
        call.enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                episodeDetail = response.body();
                episodeName.setText(episodeDetail.getNameEpisode());
                episodeOverview.setText(episodeDetail.getOverviewEpisode());
                episodeAirDate.setText(episodeDetail.getAirDateEpisode());
                episodeNumber.setText("Episodio "+episodeDetail.getNumberEpisode());
                Picasso.get().load("https://image.tmdb.org/t/p/w300" + episodeDetail.getStillEpisode()).into(episodeStill);
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {
                Toast.makeText(EpisodeDetails.this, "Hubo un error. No se puede mostrar el episodio.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}