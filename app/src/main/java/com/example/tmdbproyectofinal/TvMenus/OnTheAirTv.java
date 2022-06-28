package com.example.tmdbproyectofinal.TvMenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tmdbproyectofinal.Adapters.SeriesAdapter;
import com.example.tmdbproyectofinal.ApiManager.RetrofitClient;
import com.example.tmdbproyectofinal.Models.Tv;
import com.example.tmdbproyectofinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnTheAirTv extends AppCompatActivity {
    private Tv tvFromList;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_the_air_tv);
        listview = findViewById(R.id.lstOnTheAirTv);
        getOnTheAirList();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Intent intent = new Intent(OnTheAirTv.this, IndividualSeries.class);
                intent.putExtra("id", tvFromList.getTvList().get(position).getIdSeries());
                intent.putExtra("number_of_seasons", tvFromList.getTvList().get(position).getNumberOfSeasons());
                startActivity(intent);

            }
        });;
    }

    private void getOnTheAirList() {
        Call<Tv> call = RetrofitClient.getInstance().getMyApi().getOnTheAirTv();
        call.enqueue(new Callback<Tv>() {
            @Override
            public void onResponse(Call<Tv> call, Response<Tv> response) {
                tvFromList = response.body();
                SeriesAdapter adapterTv = new SeriesAdapter(OnTheAirTv.this, tvFromList);
                listview.setAdapter(adapterTv);
            }

            @Override
            public void onFailure(Call<Tv> call, Throwable t) {
                Toast.makeText(OnTheAirTv.this, "Hubo un error. No se puede mostrar la lista.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}