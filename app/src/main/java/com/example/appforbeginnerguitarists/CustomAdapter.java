package com.example.appforbeginnerguitarists;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private int[] images;
    private String[] names;




    public CustomAdapter(Context context, String[] names, int[] images) {
        super(context, R.layout.chords_spinner_row, names);
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public View getDropDownView(int position,View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.chords_spinner_row, null);
            TextView t1 = (TextView)row.findViewById(R.id.text_view_chord);
            ImageView i1 = (ImageView)row.findViewById(R.id.image_view_chord);

            t1.setText(names[position]);
            i1.setImageResource(images[position]);


        return row;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.chords_spinner_row, null);
        TextView t1 = (TextView)row.findViewById(R.id.text_view_chord);
        ImageView i1 = (ImageView)row.findViewById(R.id.image_view_chord);

        t1.setText(names[position]);
        i1.setImageResource(images[position]);


        return row;
    }
}
