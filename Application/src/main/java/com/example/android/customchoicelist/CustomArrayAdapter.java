package com.example.android.customchoicelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vabirba on 7/3/15.
 */

public class CustomArrayAdapter extends ArrayAdapter {

    private final Context context;
    private final String[] values;

    public CustomArrayAdapter(Context context, String[] values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.songNameId);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.song);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        if (s.equals("Sri Swamigal Potri")) {
            imageView.setImageResource(R.drawable.swami);
        } else if (s.equals("Sri Padhuka Song")) {
            imageView.setImageResource(R.drawable.padhuka);
        } else if (s.equals("Sri Managala Arthi")) {
            imageView.setImageResource(R.drawable.deepaaradhana);
        } else if(s.equals("Mahathmiyam")){
            imageView.setImageResource(R.drawable.swami_siddhars1);
        } else if(s.equals("Saranagathi Song")){
            imageView.setImageResource(R.drawable.three_swami1);
        }
        else{
         System.out.print("Invalid Song Name");
        }

        return rowView;
    }
}

