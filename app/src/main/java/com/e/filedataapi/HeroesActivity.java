package com.e.filedataapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.HeroAdapter;
import heroesapi.HeroesAPI;
import model.Heroes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class HeroesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HeroAdapter adapter;
    private ArrayList<Heroes> listHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        listHeroes = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new HeroAdapter(this, listHeroes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();
    }

    private void loadData() {
        Url.getInstance().create(HeroesAPI.class).getAllHeroes().enqueue(new Callback<ArrayList<Heroes>>() {
            @Override
            public void onResponse(Call<ArrayList<Heroes>> call, Response<ArrayList<Heroes>> response) {
                if(response.isSuccessful()){
                    adapter.updateData(response.body());
                }else{
                    Toast.makeText(HeroesActivity.this, "Failed to get hero list", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Heroes>> call, Throwable t) {
                Toast.makeText(HeroesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
