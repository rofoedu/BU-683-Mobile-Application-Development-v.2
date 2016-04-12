package com.cs683.esports_app;


/*code for section adopted from:
* http://www.i-programmer.info/programming/android/8521-android-adventures-menus-a-the-action-bar.html?start=1
* */
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class startScreen extends AppCompatActivity {

    //StateChange code taken from: Android Studio Dev. Essentials, 6th Edition
    public static final String TAG = "StateChange";
    Button button_supported_games;
    Button buttonLogin;
    Button buttonEvents;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
               Intent settings = new Intent(this, SettingsActivity.class);
                this.startActivity(settings);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Log.i(TAG, "onCreate");


        //button code and concepts taken from: youtu.be/z-gQKEjk7Wk
        button_supported_games = (Button) findViewById(R.id.buttonGameGeneral);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonEvents = (Button) findViewById(R.id.buttonEvents);

//button click that goes to preferences
        button_supported_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(startScreen.this, Preferences.class);
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


//button click that goes to espn eSports event calendar
        buttonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(Intent.ACTION_VIEW, Uri.parse("http://espn.go.com/esports/story/_/id/14556983/esports-calendar-top-events-league-legends-dota-2-hearthstone-more"));
                    startActivity(l);
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
