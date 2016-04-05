package com.cs683.esports_app;

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

public class ExpandableListDataProvider {
    public static HashMap<String, List<String>> getInfo() {

        HashMap<String, List<String>> platformDetails =
                new HashMap<String, List<String>>();

        List<String> selectGamesList = new ArrayList<String>();
        selectGamesList.add("Search for an unlisted game (leads to new page).");

        List<String> pcGamesList = new ArrayList<String>();
        pcGamesList.add("Counter-Strike: Global Operatives (CS:GO)");
        pcGamesList.add("Defense of the Ancients (DOTA) II");
        pcGamesList.add("League of Legends");
        pcGamesList.add("StarCraft II");

        List<String> ps4GamesList = new ArrayList<String>();
        ps4GamesList.add("Street Fighter V");

        List<String> wiiUGamesList = new ArrayList<String>();
        wiiUGamesList.add("Pokken Tournament");
        wiiUGamesList.add("Splatoon");
        wiiUGamesList.add("Super Smash Bros. 4");

        List<String> xb1GamesList = new ArrayList<String>();
        xb1GamesList.add("Forza Motorsport 6");
        xb1GamesList.add("Gears of War: Ultimate Edition");
        xb1GamesList.add("Halo 5");
        xb1GamesList.add("Killer Instinct");
        xb1GamesList.add("Tekken 7");
        xb1GamesList.add("Titanfall");

        List<String> mhGamesList = new ArrayList<String>();
        mhGamesList.add("Pokemon X/Y (Nintendo 3DS");

        List<String> multiGamesList = new ArrayList<String>();
        multiGamesList.add("Call of Duty: Black Ops III (PS4, XB1)");
        multiGamesList.add("EA Sports UFC 2 (PS4, XB1)");
        multiGamesList.add("FIFA 16 (PC, PS4, XB1)");
        multiGamesList.add("Hearthstone: Heroes of Warcraft (mobile, PC)");
        multiGamesList.add("Madden 16 (PS4, XB1, Wii U)");
        multiGamesList.add("Mortal Kombat (PC, PS4, XB1)");
        multiGamesList.add("NBA 2k16 (PS4, XB1)");
        multiGamesList.add("NHL 16 (PS4, XB1)");
        multiGamesList.add("Rocket League (PC, PS4, XB1)");
        multiGamesList.add("Skullgirls (PC, PS4)");
        multiGamesList.add("Smite (PC, PS4, XB1)");
        multiGamesList.add("World of Tanks (PC, XB1)");

        platformDetails.put("Extras", selectGamesList);
        platformDetails.put("PC Games", pcGamesList);
        platformDetails.put("Playstation 4 Games", ps4GamesList);
        platformDetails.put("Wii U Games", wiiUGamesList);
        platformDetails.put("Xbox One Games", xb1GamesList);
        platformDetails.put("Mobile / Handheld Games", mhGamesList);
        platformDetails.put("Multi-Platform Games", multiGamesList);

        return platformDetails;
    }
}
