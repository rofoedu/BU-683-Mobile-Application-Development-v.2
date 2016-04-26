package com.cs683.esports_app;


/*code for section adopted from:
* http://www.i-programmer.info/programming/android/8521-android-adventures-menus-a-the-action-bar.html?start=1
*
* 4/17 update:
*Boston University, MET CS 683 - Mobile Application Development (E. Braude): Lab 5
*
* 4/24 update:
* http://developer.android.com/guide/topics/ui/notifiers/notifications.html
* Boston University, MET CS 683 - Mobile Application Development (E. Braude): LC0421
* http://stackoverflow.com/questions/15120821/remove-notification-after-clicking
* http://stackoverflow.com/questions/13716723/open-application-after-clicking-on-notification
* http://stackoverflow.com/questions/2592037/is-there-a-default-back-keyon-device-listener-in-android
* http://www.androiddesignpatterns.com/2012/08/exit-application-dialogs-are-evil-dont.html
* http://stackoverflow.com/questions/4849690/start-an-application-from-notification-bar-in-android?lq=1
* */
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
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
        Log.i(TAG, "startScreen: onCreate: Start Screen");

        connManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo = connManager.getActiveNetworkInfo();
        boolean networkCheck = netInfo != null && netInfo.isConnectedOrConnecting();


        Toast toast = Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_LONG);
        if (networkCheck == true) {
            toast(String.format("App has network access!"));
        }

        else {
            toast(String.format("App is not connected to a network. Check your handset settings and try again later."));
        }

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
                Intent l = new Intent(startScreen.this, eventList.class);
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
        Log.i(TAG, "startScreen: onSaveInstanceState");
    }
    // ***********************************************************************
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "startScreen: onRestoreInstanceState");
    }
    // ***********************************************************************
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "startScreen: onStart");
    }
    // ***********************************************************************
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "startScreen: onResume");
    }
    // ***********************************************************************
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "startScreen: onPause");
    }
    // ***********************************************************************
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "startScreen: onStop");

        //attempt at logic to get backPressed method to fire only when on startScreen activity
        if (getClass() == startScreen.class) {
            onBackPressed();
        }
//notification builder for compatibility
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.controller_v1)//makes the icon the custom drawable image
                .setContentTitle("PassTheSticks")
                .setContentText("Click to return to the Start screen.")
                .setAutoCancel(true);

        Intent resultIntent = new Intent(this, startScreen.class);//where the phone goes once the notification is clicked
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(startScreen.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());//has to be declared last so that everything is added in

    }
    // ***********************************************************************
    private void toast(String aToast) {
        Toast.makeText(getApplicationContext(), aToast, Toast.LENGTH_LONG).show();
    }
    // ***********************************************************************
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "startScreen: onRestart: Start Screen");
    }
    // ***********************************************************************
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "startScreen: onDestroy");
    }

    // ***********************************************************************
    //alert that fires once the back button is pressed
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exiting Application")
                .setMessage("Are you sure you want to exit the app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
