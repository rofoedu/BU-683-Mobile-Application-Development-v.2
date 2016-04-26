package com.cs683.esports_app;


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*code for section adopted from following sources:
* https://gist.github.com/Psest328/8762232
* http://www.101apps.co.za/index.php/articles/expandable-lists.html
* http://stackoverflow.com/questions/14373811/expandable-listview-isnt-displaying
* http://stackoverflow.com/questions/5068668/android-expandablelistview-with-checkbox-controlling-checked-state
* https://youtu.be/BkazaAeeW1Q
* https://youtu.be/_h94Kqyc-Ag
* https://youtu.be/oPGdPQvqPVM
*
*       4/17 update
*  http://android.okhelp.cz/start-activity-from-listview-item-click-android-example/
*
*  4/24 update
*  http://stackoverflow.com/questions/4849690/start-an-application-from-notification-bar-in-android?lq=1
* http://stackoverflow.com/questions/15120821/remove-notification-after-clicking
* */

public class Preferences extends AppCompatActivity {

    //declaring variables
    public static final String TAG = "StateChange";
    HashMap<String, List<String>> platformsHash;
    List<String> gamesList;
    ExpandableListView expGames;
    platformExpandableListAdapter adapter;
// ***********************************************************************
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        Log.i(TAG, "Preferences: onCreate: Preferences");

        //linking Expandable list view here to widget/container in xml file
        expGames = (ExpandableListView) findViewById(R.id.expandableListView);

        //provides link between this activity and data provider java activity
        platformsHash = ExpandableListDataProvider.getInfo();

        //placing the games list within the existing platformHash
        gamesList = new ArrayList<String>(platformsHash.keySet());

        //setting up adapter to read from hashmap and arraylist + convert them into data
        adapter = new platformExpandableListAdapter(this, platformsHash, gamesList);
        expGames.setAdapter(adapter);

        // ***********************************************************************
        //method is executed whenever a group is expanded
        expGames.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getBaseContext(), "Opened: " + gamesList.get(groupPosition),
                        Toast.LENGTH_SHORT).show();

            }
        });//onGroupExpand

        // ***********************************************************************
        //method is executed whenever a group is collapsed
        expGames.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(), "Closed: " + gamesList.get(groupPosition),
                        Toast.LENGTH_SHORT).show();
            }

        });//onGroupCollapse

        // ***********************************************************************
        expGames.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {

        //toast readout of whatever child was selected within the expandable list view
                Toast.makeText(getBaseContext(), "Tapped: " + platformsHash.get((gamesList).get(groupPosition)).get(childPosition)
                        + " from the " + gamesList.get(groupPosition) + " collection.", Toast.LENGTH_SHORT).show();

                //makes simple system + game name variables
                String gameName = platformsHash.get((gamesList).get(groupPosition)).get(childPosition);

//website click outs for all child views in expandableListView
//XB1 Games
                if (gameName == "Forza Motorsport 6") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Forza_Motorsport_6"));
                    startActivity(browserIntent);
                }//forza 6

                if (gameName == "Gears of War: Ultimate Edition") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://gearsofwar.com/en-us/games/gears-of-war-ultimate"));
                    startActivity(browserIntent);
                }//gears UE

                if (gameName == "Halo 5") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.xbox.com/en-US/games/halo-5-guardians"));
                    startActivity(browserIntent);
                }//halo 5

                if (gameName == "Killer Instinct") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://store.xbox.com/en-US/Xbox-One/Games/Killer-Instinct/8b4cfd5d-52ff-4ca0-b5e2-112d7fd09830#gameDetailsSection"));
                    startActivity(browserIntent);
                }//KI

                if (gameName == "Tekken 7") { //tekken 7 game
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Tekken_7"));
                        startActivity(browserIntent);
                    }//Tekken 7

                if (gameName == "Titanfall") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Titanfall"));
                    startActivity(browserIntent);
                }//titanfall

//Wii U Games
                if (gameName == "Pokken Tournament") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.nintendo.com/games/detail/pokken-tournament-wii-u"));
                    startActivity(browserIntent);
                }//pokken

                if (gameName == "Splatoon") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Splatoon"));
                    startActivity(browserIntent);
                }//Splatoon

                if (gameName == "Super Smash Bros. 4") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.smashbros.com/us/"));
                    startActivity(browserIntent);
                }//sm4sh

//PS4 Games
                if (gameName == "Guilty Gear Xrd -REVELATOR-") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Guilty_Gear_Xrd"));
                    startActivity(browserIntent);
                }//Guilty Gear

                if (gameName == "Street Fighter V") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Street_Fighter_V"));
                    startActivity(browserIntent);
                }//SFV

//Extras
                if (gameName == "Tap to view more eSports games.") {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://gamebattles.majorleaguegaming.com/games"));
                        startActivity(browserIntent);
                }//extras group

//Mobile/Handheld games
                if (gameName == "Pokemon X/Y (Nintendo 3DS)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Pok%C3%A9mon_X_and_Y"));
                    startActivity(browserIntent);
                }//pokemon

//multi-platform games
                if (gameName == "Call of Duty: Black Ops III (PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.callofduty.com/blackops3"));
                    startActivity(browserIntent);
                }//BOIII

                if (gameName == "EA Sports UFC 2 (PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/EA_Sports_UFC_2"));
                    startActivity(browserIntent);
                }//UFC 2

                if (gameName == "FIFA 16 (PC, PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/FIFA_16"));
                    startActivity(browserIntent);
                }//FIFA 16

                if (gameName == "Hearthstone: Heroes of Warcraft (mobile, PC)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Hearthstone:_Heroes_of_Warcraft"));
                    startActivity(browserIntent);
                }//hearthstone

                if (gameName == "Madden 16 (PS4, XB1, Wii U)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Madden_NFL_16"));
                    startActivity(browserIntent);
                }//madden 16

                if (gameName == "Mortal Kombat X (PC, PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Mortal_Kombat_X"));
                    startActivity(browserIntent);
                }//mortal kombat

                if (gameName == "NBA 2k16 (PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/NBA_2K16"));
                    startActivity(browserIntent);
                }//2k16

                if (gameName == "NHL 16 (PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/NHL_16"));
                    startActivity(browserIntent);
                }//nhl 16

                if (gameName == "Rocket League (PC, PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.rocketleaguegame.com/"));
                    startActivity(browserIntent);
                }//rocket League

                if (gameName == "Skullgirls (PC, PS4)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://skullgirls.com/"));
                    startActivity(browserIntent);
                }//skullgirls

                if (gameName == "Smite (PC, PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.smitegame.com"));
                    startActivity(browserIntent);
                }//Smite

                if (gameName == "Ultimate Marvel vs. Capcom 3 (PS4, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Ultimate_Marvel_vs._Capcom_3"));
                    startActivity(browserIntent);
                }//UMVC3

                if (gameName == "World of Tanks (PC, XB1)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://worldoftanks.com/"));
                    startActivity(browserIntent);
                }//WoT

//PC Games
                if (gameName == "Counter-Strike: Global Operatives (CS:GO)") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Counter-Strike:_Global_Offensive"));
                    startActivity(browserIntent);
                }//cs:go

                if (gameName == "Defense of the Ancients (DOTA) II") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/Dota_2"));
                    startActivity(browserIntent);
                }//DOTA II

                if (gameName == "League of Legends") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/League_of_Legends"));
                    startActivity(browserIntent);
                }//LoL

                if (gameName == "StarCraft II") {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://en.wikipedia.org/wiki/StarCraft_II:_Wings_of_Liberty"));
                    startActivity(browserIntent);
                }//SC II
                return false;
            }//onChildClick
        });//setOnChildClickListener

    }//onCreate
    // ***********************************************************************



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Preferences: onSaveInstanceState");
    }
    // ***********************************************************************
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "Preferences: onRestoreInstanceState");
    }
    // ***********************************************************************
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Preferences: onStart");
    }
    // ***********************************************************************
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Preferences: onResume");
    }
    // ***********************************************************************
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Preferences: onPause");
    }
    // ***********************************************************************
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Preferences: onStop");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.controller_v1)
                .setContentTitle("PassTheSticks")
                .setContentText("Click to return to the Supported Games screen.")
                .setAutoCancel(true);

        Intent resultIntent = new Intent(this, Preferences.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(startScreen.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());


    }
    // ***********************************************************************
    private void toast(String aToast) {
        Toast.makeText(getApplicationContext(), aToast, Toast.LENGTH_LONG).show();
    }
    // ***********************************************************************
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Preferences: onRestart");
    }
    // ***********************************************************************
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Preferences: onDestroy");
    }

}//prefs class




