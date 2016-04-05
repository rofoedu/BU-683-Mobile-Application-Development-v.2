package com.cs683.esports_app;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class startScreen extends AppCompatActivity {

    //StateChange code taken from: Android Studio Dev. Essentials, 6th Edition
    public static final String TAG = "StateChange";
    Button button_supported_games;
    Button buttonLogin;
    Button buttonPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Log.i(TAG, "onCreate");

        //button code and concepts taken from: youtu.be/z-gQKEjk7Wk
        button_supported_games = (Button) findViewById(R.id.buttonGameGeneral);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonPrefs = (Button) findViewById(R.id.buttonPrefs);

//button click that goes to supported games
        button_supported_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(startScreen.this, SupportedGamesGeneral.class);
                startActivity(i);
            }
        });

//button click that goes to Login activity
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(startScreen.this, LoginActivity.class);
                startActivity(j);
            }
        });

//button click that goes to preferences page
        buttonPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(startScreen.this, Preferences.class);
                startActivity(k);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
