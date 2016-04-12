package com.cs683.esports_app;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
public class platformExpandableListAdapter extends BaseExpandableListAdapter {

    //define context
    private Context c;

    /*defining string hashmap and nested string list
     * the gaming platforms are in the hashmap, and games in the list.
      * because counts go from (0,0), then (0,1), then (1,0),
      * have to declare platforms first*/
    private HashMap<String, List<String>> platforms;
    private List<String> platformsList;


    //defining adapter method with above variables, to be called at later time
    public platformExpandableListAdapter(Context c, HashMap<String, List<String>> platforms, List<String> platformsList) {
        this.c = c;
        this.platforms = platforms;
        this.platformsList = platformsList;
    }


    //returns number of platforms in hashmap
    @Override
    public int getGroupCount() {
        return platformsList.size();
    }

    //returns number of games (children) within each platform (parent)
    @Override
    public int getChildrenCount(int groupPosition) {

        return platforms.get(platformsList.get(groupPosition)).size();
    }

    //denotes which platform (parent) is currently selected
    @Override
    public Object getGroup(int groupPosition) {
        return platformsList.get(groupPosition);
    }

    //deontes which game (child) is selected within the given platform (parent)
    @Override
    public Object getChild(int parent, int child) {


        return platforms.get(platformsList.get(parent)).get(child);
    }

    //denotes specific number of platform (parent) position
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //denotes specific number of game (child) position
    @Override
    public long getChildId(int parent, int child) {

        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    //how parent items will appear in the list
    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {

        String parent_title = (String) getGroup(parent);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout, parentView, false);
        }

        TextView parentTextView = (TextView) convertView.findViewById(R.id.parent_txt);
        parentTextView.setTypeface(null, Typeface.BOLD);
        parentTextView.setText(parent_title);

        return convertView;
    }

    //how child items will appear in the list
    @Override
    public View getChildView(final int parent, final int child, boolean isLastChild, View convertView, ViewGroup parentView) {

        String child_title = (String) getChild(parent, child);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, parentView, false);
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.child_txt);
        childTextView.setText(child_title);

        return convertView;
    }

    //denotes if a child item can be selected
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
