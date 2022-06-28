package com.example.tmdbproyectofinal.TvMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Series;
import com.example.tmdbproyectofinal.MoviesMenus.IndividualMovie;
import com.example.tmdbproyectofinal.MoviesMenus.RelatedMovies;
import com.example.tmdbproyectofinal.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndividualSeries extends AppCompatActivity {

    private Series individualSeries;
    private String id;
    private String numberOfSeasons;
    ImageView seriesPoster;
    TextView seriesName;
    TextView seriesOverview;
    TextView seriesFirstAir;
    TextView seriesSeasons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_series);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        numberOfSeasons = intent.getStringExtra("number_of_seasons");
        seriesPoster = findViewById(R.id.imgSeriesIndividual);
        seriesName = findViewById(R.id.txtSeriesNameInd);
        seriesOverview = findViewById(R.id.txtSeriesOverviewInd);
        seriesFirstAir = findViewById(R.id.txtSeriesFirstInd);
        seriesSeasons = findViewById(R.id.txtSeriesNumSeasons);
        getSeriesSeasons(id);

        seriesSeasons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(IndividualSeries.this, SeriesSeasons.class);
                Call<Series> call = RetrofitClient.getInstance().getMyApi().getTv(id);
                call.enqueue(new Callback<Series>() {
                    @Override
                    public void onResponse(Call<Series> call, Response<Series> response) {
                        individualSeries = response.body();
                        numberOfSeasons = individualSeries.getNumberOfSeasons();

                        intent.putExtra("id", id);
                        intent.putExtra("numberOfSeasons", numberOfSeasons);
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<Series> call, Throwable t) {
                        Toast.makeText(IndividualSeries.this, "Hubo un error. No se puede mostrar la serie.", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }

    private void getSeriesSeasons(String id) {
        Call<Series> call = RetrofitClient.getInstance().getMyApi().getTv(id);
        call.enqueue(new Callback<Series>() {
            @Override
            public void onResponse(Call<Series> call, Response<Series> response) {
                individualSeries = response.body();
                seriesName.setText(individualSeries.getNameSeries());
                seriesOverview.setText(individualSeries.getOverviewSeries());
                seriesFirstAir.setText(individualSeries.getFirstAirTv());
                seriesSeasons.setText("Toca acá para ver las temporadas.");
                Picasso.get().load("https://image.tmdb.org/t/p/w300" + individualSeries.getPosterSeries()).into(seriesPoster);
            }

            @Override
            public void onFailure(Call<Series> call, Throwable t) {
                Toast.makeText(IndividualSeries.this, "Hubo un error. No se puede mostrar la serie.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}