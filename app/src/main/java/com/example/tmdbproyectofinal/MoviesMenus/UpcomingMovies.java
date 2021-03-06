package com.example.tmdbproyectofinal.MoviesMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tmdbproyectofinal.Adapters.MovieAdapter;
import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Movies;
import com.example.tmdbproyectofinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpcomingMovies extends AppCompatActivity {
    private Movies moviesFromList;
    ListView listview;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_movies);
        listview = findViewById(R.id.lstUpcomingMovies);
        getUpcomingMoviesList();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Intent intent = new Intent(UpcomingMovies.this, IndividualMovie.class);
                intent.putExtra("id", moviesFromList.getMovieList().get(position).getIdMovie());
                startActivity(intent);

            }
        });;
    }

    private void getUpcomingMoviesList() {
        Call<Movies> call = RetrofitClient.getInstance().getMyApi().getUpcomingMovies();
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                moviesFromList = response.body();
                MovieAdapter adapterMovie = new MovieAdapter(UpcomingMovies.this, moviesFromList);
                listview.setAdapter(adapterMovie);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Toast.makeText(UpcomingMovies.this, "Hubo un error. No se puede mostrar la lista.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}