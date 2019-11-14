package com.hfad.mobilefitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

// Coded By John Resar
public class Injury_two extends AppCompatActivity {

    private Switch neck,shoulders,back,feet,legs,arms;
    private Button finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_two);
        neck = findViewById(R.id.neck);
        shoulders = findViewById(R.id.shoulders);
        back = findViewById(R.id.back);
        feet = findViewById(R.id.feet);
        legs = findViewById(R.id.legs);
        arms = findViewById(R.id.legs);
        finished = findViewById(R.id.finished);
        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(neck.isChecked());
                //add combining code
                if(shoulders.isChecked());
                //add combining code
                if(back.isChecked());
                //add combining code
                if(arms.isChecked());
                //add combining code
                if(legs.isChecked());
                //add combining code
                if(feet.isChecked());
                //add combining code
                //openNextScreen();
                //This will take the user to the next screen having taken into account what injured
                //part should not be utilized
            }
        });

    }


}
