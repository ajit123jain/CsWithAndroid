package com.example.ajit.learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button DateTime1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DateTime1 = (Button)findViewById(R.id.DateTime);

    }

    @Override
    public void onClick(View v) {
        if(v==DateTime1){
         startActivity(new Intent(this,DateTime_Picker.class));
        }
    }

    public void DT(View view) {
        startActivity(new Intent(this,DateTime_Picker.class));
    }

}
