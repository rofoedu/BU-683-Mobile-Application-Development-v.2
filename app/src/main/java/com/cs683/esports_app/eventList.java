package com.cs683.esports_app;


/*code below  parsed from following sources:
*http://codetheory.in/understanding-android-lists/ */
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class eventList extends AppCompatActivity {

    Button eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        String [] upcomingEventsSummer2016 = {
                "Northwest Majors 8" +
                        "\n(04/29 – 05/01)" +
                        "\nDes Moines, WA, USA",
                "DreamHack Austin 2016" +
                        "\n(05/06 – 05/08)" +
                        "\nAustin, TX, USA",
                "Battle Arena Melbourne 8" +
                        "\n(05/13 – 05/15)" +
                        "\nMelbourne, Australia",
                "Stunfest 2016" +
                        "\n(05/20 – 05/22)" +
                        "\nRennes, France",
                "Lima Salty 3" +
                        "\n(05/20 – 05/22)" +
                        "\nLima, Peru",
                "Toryuken 5" +
                        "\n(05/20 – 05/22)" +
                        "\nToronto, Canada",
                "Combo Breaker 2016" +
                        "\n(05/27 – 05/29)" +
                        "\nSt. Charles, IL, USA",
                "FFM Rumble #9" +
                        "\n(05/27 – 05/29)" +
                        "\nFrankfurt, Germany",
                "Ze Fighting Game Championship" +
                        "\n(05/28 – 05/29)" +
                        "\nChina",
                "Japonawa 2016" +
                        "\n(05/28 – 05/29)" +
                        "\nTijuana, Mexico",
                "The Fight" +
                        "\n(06/05)" +
                        "\nColombia",
                "Moscow Fighting Arena" +
                        "\n(06/11 – 06/13)" +
                        "\nMoscow, Russia",
                "DreamHack Summer 2016" +
                        "\n(06/18 – 06/21)" +
                        "\nJönköping, Sweden",
                "CEO 2016" +
                        "\n(06/24 – 06/26)" +
                        "\nOrlando, FL, USA",
                "Sonic Boom Summer Edition 2016" +
                        "\n(07/02 – 07/03)" +
                        "\nMadrid, Spain",
                "G-League" +
                        "\n(07/09)" +
                        "\nChina",
                "EVO 2016" +
                        "\n(07/15 – 07/17)" +
                        "\nLas Vegas, NV, USA",
                "SANA" +
                        "\n(07/15 – 07/17)" +
                        "\nBrazil",
                "Defend the North 2016" +
                        "\n(07/29 – 07/31)" +
                        "\nWhite Plains, NY, USA",
                "VSFighting 2016" +
                        "\n(08/06 – 08/07)" +
                        "\nBirmingham, England",
                "Yangcheng Cup" +
                        "\n(08/13 – 08/14)" +
                        "\nChina",
                "Summer Jam 10" +
                        "\n(08/19 – 08/21)" +
                        "\nPhiladelphia, PA, USA",
                "CGA" +
                        "\n(08/20)" +
                        "\nHong Kong, China",
                "Absolute Battle 7" +
                        "\n(08/26 – 08/28)" +
                        "\nDallas, TX, USA",
                "OzHadou Nationals 14" +
                        "\n(08/26 – 08/28)" +
                        "\nSydney, Australia"
        };

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, upcomingEventsSummer2016);

        ListView listView = (ListView) findViewById(R.id.eventList);
        listView.setAdapter(adapter);

        eventList = (Button) findViewById(R.id.buttonWebEvents);

        eventList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://espn.go.com/esports/story/_/id/14556983/esports-calendar-top-events-league-legends-dota-2-hearthstone-more"));
            startActivity(i);
            }
        });
    }
}
