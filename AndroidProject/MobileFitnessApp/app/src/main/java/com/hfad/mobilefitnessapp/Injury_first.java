package com.hfad.mobilefitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Coded By John Resar
public class Injury_first extends AppCompatActivity {

    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_first);
        button = findViewById(R.id.buttonYes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openInjuredLocation();
            }
        });
        button2 = findViewById(R.id.buttonNo);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openNextScreen();
//            }
//        });
    }
//    public void openInjuredLocation(){
//        Intent intent = new Intent(this, InjuryLocation.class);
//        startActivity(intent);
//
//    }
//    public void openNextScreen(){
//        Intent intent = new Intent(this, NextScreen.class);
//        startActivity(intent);
//        //NextScreen would be the next view the user sees after selecting they have no Injury
//    }
}