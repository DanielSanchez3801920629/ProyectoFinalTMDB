package com.example.tmdbproyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tmdbproyectofinal.ApiManager.Api;
import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Movie;
import com.example.tmdbproyectofinal.Models.Movies;
import com.example.tmdbproyectofinal.MoviesMenus.MoviesMainMenu;
import com.example.tmdbproyectofinal.MoviesMenus.PopularMovies;
import com.example.tmdbproyectofinal.TvMenus.LatestTv;
import com.example.tmdbproyectofinal.TvMenus.OnTheAirTv;
import com.example.tmdbproyectofinal.TvMenus.TvMainMenu;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Movies moviesFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.peliBtn:
                goToMovies();
                break;
            case R.id.tvBtn:
                goToTv();
                break;
        }
    }

    private void goToMovies() {
        Intent intent = new Intent(MainActivity.this, MoviesMainMenu.class);
        startActivity(intent);
    }
    private void goToTv() {
        Intent intent = new Intent(MainActivity.this, TvMainMenu.class);
        startActivity(intent);
    }
}