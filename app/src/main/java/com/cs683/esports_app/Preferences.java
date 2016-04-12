package com.cs683.esports_app;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
* */

public class Preferences extends AppCompatActivity {

    //declaring variables
    HashMap<String, List<String>> platformsHash;
    List<String> gamesList;
    ExpandableListView expGames;
    platformExpandableListAdapter adapter;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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

                Toast.makeText(getBaseContext(), "Group "+groupPosition+", item "+childPosition,Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(), "Tapped: " + platformsHash.get((gamesList).get(groupPosition)).get(childPosition)
                        + " from the " + gamesList.get(groupPosition) + " collection.", Toast.LENGTH_SHORT).show();

                if (groupPosition == 2) {
                    if (childPosition == 0) {

                        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/List_of_esports_games"));
                        startActivity(browserIntent);
                    }
                }

                return false;
            }
        });//setOnChildClickListener


    }//onCreate
}//prefs class




