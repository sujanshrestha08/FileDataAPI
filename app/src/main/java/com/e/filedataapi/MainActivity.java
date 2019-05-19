package com.e.filedataapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import heroesapi.HeroesAPI;
import model.Heroes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import url.Url;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etDescription;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etDescription =findViewById(R.id.etDesc);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });

    }
        private void Save() {
            String name = etName.getText().toString();
            String desc = etDescription.getText().toString();

            Heroes heroes = new Heroes(name, desc);

            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Url.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            HeroesAPI heroesAPI = retrofit.create(HeroesAPI.class);

            Call<Void> heroesCall = heroesAPI.addHero(heroes);

            heroesCall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Code " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    Toast.makeText(MainActivity.this, "Successfully Added", Toast.LENGTH_LONG).show();
                    return;
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });

    }

}
