package com.example.ajit.hacathon;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter extends BaseAdapter {
    private Context mContext;
    private final String[] web;


    public Myadapter(Context c,String[] web) {
        mContext = c;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.activity_myadapter, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setTextColor(Color.parseColor("#ffffff"));
            textView.setText(web[position]);
            textView.setBackgroundColor(Color.parseColor("#000000"));
        } else {
            grid = (View) convertView;
        }

        return grid;
    }


    }
