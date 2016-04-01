package com.cs683.esports_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SupportedGamesGeneral extends AppCompatActivity {

    Button buttonNextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supported_games__general);

        buttonNextPage = (Button) findViewById(R.id.buttonNextPage);

        //declare spinner
        /*spinner concepts and code taken from following sites:
        http://www.tutorialspoint.com/android/android_spinner_control.htm
        http://www.ahotbrew.com/android-dropdown-spinner-example/
        http://www.journaldev.com/9231/android-spinner-bundle-and-toast-example*/
        Spinner spinner = (Spinner) findViewById(R.id.consoleDynamicSpinner);

        //spinner drop down elements
        final String [] consoles = new String[] {"(Select)", "PC", "Playstation 4", "Wii U",
                "Xbox One", "Mobile / Handheld", "Multi-Platform"};

        //creating spinner adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, consoles);

        //attaching adapter to spinner
        spinner.setAdapter(adapter);


       //spinner on click + toast settings
       //toast code taken from:  http://www.journaldev.com/9231/android-spinner-bundle-and-toast-example
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                 parent.getItemAtPosition(position);

                if (position > 0) {
                    TextView myText = (TextView) view;
                    Toast.makeText(parent.getContext(), "Selected console: " + myText.getText(), Toast.LENGTH_SHORT).show();
                }

                buttonNextPage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //linking to PC activity list
                        if (position == 1) {
                            Intent gamesPC = new Intent(SupportedGamesGeneral.this, SupportedGamesPC.class);
                            startActivity(gamesPC);
                        }

                        //linking to Playstation 4 activity list
                        else if (position == 2) {
                            Intent gamesPS4 = new Intent(SupportedGamesGeneral.this, SupportedGamesPS4.class);
                            startActivity(gamesPS4);
                        }

                        //linking to Wii U activity list
                        else if (position == 3) {
                            Intent gamesWiiU = new Intent(SupportedGamesGeneral.this, SupportedGamesWiiU.class);
                            startActivity(gamesWiiU);
                        }

                        //linking to Xbox One activity list
                        else if (position ==4){
                            Intent gamesXboxOne = new Intent(SupportedGamesGeneral.this,
                                    SupportedGamesXboxOne.class);

                            startActivity(gamesXboxOne);
                        }

                        //linking to Mobile / Handheld activity list
                        else if (position == 5) {
                            Intent gamesMH = new Intent (SupportedGamesGeneral.this, SupportedGamesMH.class);
                            startActivity(gamesMH);
                        }

                        //linking to multi-platform games
                        else {
                            Intent gamesMulti = new Intent (SupportedGamesGeneral.this, SupportedGamesMulti.class);
                            startActivity(gamesMulti);
                        }

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}
