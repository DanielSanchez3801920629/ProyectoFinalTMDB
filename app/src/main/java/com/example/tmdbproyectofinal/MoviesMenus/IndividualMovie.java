package com.example.tmdbproyectofinal.MoviesMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Movie;
import com.example.tmdbproyectofinal.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndividualMovie extends AppCompatActivity{

    private Movie individualMovie;
    ImageView imageMovie;
    TextView titleMovie;
    TextView overviewMovie;
    TextView releaseMovie;
    Button relatedMovies;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_movie);
        Intent intent = getIntent();
        imageMovie = findViewById(R.id.imgMovie);
        titleMovie = findViewById(R.id.txtTitleMovie);
        overviewMovie = findViewById(R.id.txtOverviewMovie);
        releaseMovie = findViewById(R.id.txtReleaseMovie);
        relatedMovies = findViewById(R.id.btnRelatedMovies);
        id = intent.getStringExtra("id");
        getPopularMovieIndividual(id);

        relatedMovies.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(IndividualMovie.this, RelatedMovies.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    private void getPopularMovieIndividual(String id) {
        Call<Movie> call = RetrofitClient.getInstance().getMyApi().getMovie(id);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                individualMovie = response.body();
                titleMovie.setText(individualMovie.getTitleMovie());
                overviewMovie.setText(individualMovie.getOverviewMovie());
                releaseMovie.setText(individualMovie.getReleaseMovie());
                Picasso.get().load("https://image.tmdb.org/t/p/w300" + individualMovie.getPosterMovie()).into(imageMovie);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(IndividualMovie.this, "Hubo un error. No se puede mostrar la lista.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}