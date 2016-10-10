package com.example.ajit.hacathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    String[] web = {



    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Myadapter adapter = new Myadapter(MainActivity.this, web);
        grid=(GridView)findViewById(R.id.gridView);
        grid.setAdapter(adapter);

        final int size = grid.getChildCount();
        for(int i = 0; i < size; i++) {
            ViewGroup gridChild = (ViewGroup) grid.getChildAt(i);
            int childSize = gridChild.getChildCount();
            for(int k = 0; k < childSize; k++) {
                if( gridChild.getChildAt(k) instanceof TextView) {
                    gridChild.getChildAt(k).setVisibility(View.GONE);
                }
            }
        }



    }
}
