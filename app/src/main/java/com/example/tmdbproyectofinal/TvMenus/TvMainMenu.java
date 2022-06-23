package com.example.tmdbproyectofinal.TvMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tmdbproyectofinal.MoviesMenus.MoviesMainMenu;
import com.example.tmdbproyectofinal.MoviesMenus.UpcomingMovies;
import com.example.tmdbproyectofinal.R;

public class TvMainMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_main_menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pupularTvBtn:
                goToPopularTv();
                break;
            case R.id.ultimoTvBtn:
                goToLatestTv();
                break;
            case R.id.mejorTvBtn:
                goToTopRatedTv();
                break;
            case R.id.aireTvBtn:
                goToAirTv();
                break;
        }
    }

    private void goToPopularTv() {
        Intent intent = new Intent(TvMainMenu.this, PopularTv.class);
        startActivity(intent);
    }
    private void goToLatestTv() {
        Intent intent = new Intent(TvMainMenu.this, LatestTv.class);
        startActivity(intent);
    }
    private void goToTopRatedTv() {
        Intent intent = new Intent(TvMainMenu.this, TopRatedTv.class);
        startActivity(intent);
    }
    private void goToAirTv() {
        Intent intent = new Intent(TvMainMenu.this, OnTheAirTv.class);
        startActivity(intent);
    }
}