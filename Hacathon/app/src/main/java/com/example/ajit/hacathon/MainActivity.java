package com.example.ajit.hacathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    String[] web = {
            "1","1",
            "2",
            "3",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "2",
            "3",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14"


    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Myadapter adapter = new Myadapter(MainActivity.this, web);
        grid=(GridView)findViewById(R.id.gridView);
        grid.setAdapter(adapter);
        int size=grid.getChildCount();
        for(int i=0; i<size; i++){
            ViewGroup gridchild=(ViewGroup)grid.getChildAt(i);

        }



    }
}
