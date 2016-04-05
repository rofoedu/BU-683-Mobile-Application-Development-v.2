package com.cs683.esports_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.io.Serializable;
import java.sql.Array;
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
* */

public class Preferences extends AppCompatActivity {

    //declaring variables
    SharedPreferences.Editor fd;
    SharedPreferences feedPref;
    HashMap<String, List<String>> platformsHash;
    List<String> gamesList;
    ExpandableListView expGames;
    platformExpandableListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        //linking Expandable list view here to widget/container in xml file
        expGames = (ExpandableListView) findViewById(R.id.expandableListView);

        //provides link between this activity and data provider java activity
        platformsHash = ExpandableListDataProvider.getInfo();

        //placing the games list within the existing platformHash
        gamesList = new ArrayList<String>(platformsHash.keySet());

        //setting up adapter to read from hashmap and arraylist + convert them into data
        adapter = new platformExpandableListAdapter(this, platformsHash, gamesList);
        expGames.setAdapter(adapter);

        //method is executed whenever a group is expanded
        expGames.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getBaseContext(), "Opened: " + gamesList.get(groupPosition),
                        Toast.LENGTH_SHORT).show();

            }
        });//onGroupExpand


        //method is executed whenever a group is collapsed
        expGames.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(), "Closed: " + gamesList.get(groupPosition),
                        Toast.LENGTH_SHORT).show();
            }

        });//onGroupCollapse

        //toast readout of whatever child was selected within the expandable list view
        expGames.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, final int childPosition, long id) {

                feedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                fd = feedPref.edit();

                Toast.makeText(getBaseContext(), "Tapped: " + platformsHash.get((gamesList).get(groupPosition)).get(childPosition)
                        + " from the " + gamesList.get(groupPosition) + " collection", Toast.LENGTH_LONG).show();
                return false;
            }
        });//setOnChildClickListener

        Button prefsView = (Button) findViewById(R.id.prefsView);

        if (prefsView != null) {
            prefsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Preferences.this, PreferencesOutput.class);
                    startActivity(i);
                }//prefsView onClick
            });
        }//if PrefsView isnt null

    }//onCreate
}//prefs class




