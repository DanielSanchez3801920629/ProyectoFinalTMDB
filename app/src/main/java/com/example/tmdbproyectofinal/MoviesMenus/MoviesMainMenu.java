package com.example.tmdbproyectofinal.MoviesMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tmdbproyectofinal.R;

public class MoviesMainMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_main_menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.popularBtn:
                goToPopularMovies();
                break;
            case R.id.ultimoBtn:
                goToLatestMovies();
                break;
            case R.id.mejorBtn:
                goToTopRatedMovies();
                break;
            case R.id.proxiBtn:
                goToLatestUpcomingMovies();
                break;
        }
    }

    private void goToLatestUpcomingMovies() {
        Intent intent = new Intent(MoviesMainMenu.this, UpcomingMovies.class);
        startActivity(intent);
    }

    private void goToTopRatedMovies() {
        Intent intent = new Intent(MoviesMainMenu.this, TopRatedMovies.class);
        startActivity(intent);
    }

    private void goToLatestMovies() {
        Intent intent = new Intent(MoviesMainMenu.this, NowPlayingMovies.class);
        startActivity(intent);
    }

    private void goToPopularMovies() {
        Intent intent = new Intent(MoviesMainMenu.this, PopularMovies.class);
        startActivity(intent);
    }
}