package com.e.filedataapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import heroesapi.HeroesAPI;
import model.Heroes;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;

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

            Heroes heroes = name Heroes(name, desc);

            Retrofit retrofit = ne

            HeroesAPI heroesAPI = retrofit.create(HeroesAPI.class);

            Call<Void> heroesAPI.addHero(heroes);

    }

}
