package com.example.tmdbproyectofinal.MoviesMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tmdbproyectofinal.Adapters.MovieAdapter;
import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Movies;
import com.example.tmdbproyectofinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelatedMovies extends AppCompatActivity {
    private Movies moviesFromList;
    ListView listview;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_movies);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        listview = findViewById(R.id.lstRelatedMovies);
        getRelatedMoviesList(id);
    }

    private void getRelatedMoviesList(String id) {
        Call<Movies> call = RetrofitClient.getInstance().getMyApi().getSimilarMovies(id);
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                moviesFromList = response.body();
                MovieAdapter adapterMovie = new MovieAdapter(RelatedMovies.this, moviesFromList);
                listview.setAdapter(adapterMovie);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Toast.makeText(RelatedMovies.this, "Hubo un error. No se puede mostrar la lista.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}