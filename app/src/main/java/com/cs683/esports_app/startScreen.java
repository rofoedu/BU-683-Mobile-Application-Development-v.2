package com.cs683.esports_app;


/*code for section adopted from:
* http://www.i-programmer.info/programming/android/8521-android-adventures-menus-a-the-action-bar.html?start=1
*
* 4/17 update:
*Boston University, MET CS 683 - Mobile Application Development (E. Braude): Lab 5
* */
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class startScreen extends AppCompatActivity {

    //StateChange code taken from: Android Studio Dev. Essentials, 6th Edition
    public static final String TAG = "StateChange";
    Button button_supported_games;
    Button buttonLogin;
    Button buttonEvents;
    Button buttonTeamRankings;
    ConnectivityManager connManager;
    NetworkInfo netInfo;
    // ***********************************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }
    // ***********************************************************************
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
    // ***********************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Log.i(TAG, "onCreate");

        connManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo = connManager.getActiveNetworkInfo();
        boolean networkCheck = netInfo != null && netInfo.isConnectedOrConnecting();


        Toast toast = Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_LONG);
        toast(String.format("Connected to the network?: %s", networkCheck));
        toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
        toast.show();

        //button code and concepts taken from: youtu.be/z-gQKEjk7Wk
        button_supported_games = (Button) findViewById(R.id.buttonGameGeneral);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonEvents = (Button) findViewById(R.id.buttonEvents);
        buttonTeamRankings = (Button) findViewById(R.id.teamRankings);

        // ***********************************************************************
        //button click that goes to preferences
        button_supported_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(startScreen.this, Preferences.class);
                startActivity(i);
            }
        });

        // ***********************************************************************
        //button click that goes to Login activity
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(startScreen.this, LoginActivity.class);
                startActivity(j);
            }
        });

        // ***********************************************************************
        //button click that goes to espn eSports event calendar
        buttonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(Intent.ACTION_VIEW, Uri.parse("http://espn.go.com/esports/story/_/id/14556983/esports-calendar-top-events-league-legends-dota-2-hearthstone-more"));
                    startActivity(l);
            }
        });

        // ***********************************************************************
        buttonTeamRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gosugamers.net/rankings"));
            startActivity(m);
            }
        });
    }
    // ***********************************************************************
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }
    // ***********************************************************************
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }
    // ***********************************************************************
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }
    // ***********************************************************************
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }
    // ***********************************************************************
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }
    // ***********************************************************************
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }
    // ***********************************************************************
    private void toast(String aToast) {
        Toast.makeText(getApplicationContext(), aToast, Toast.LENGTH_LONG).show();
    }
    // ***********************************************************************
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
    // ***********************************************************************
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
