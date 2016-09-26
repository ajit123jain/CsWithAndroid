package com.example.rajeevpc.sqliteapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
   DatabaseHelper myDb;
    EditText editname,editsurname,editmarks;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      myDb=new DatabaseHelper(this);
        editname=(EditText)findViewById(R.id.editText_name);
        editsurname=(EditText)findViewById(R.id.editText2_surname);
        editmarks=(EditText)findViewById(R.id.editText3_marks);
        btnAddData=(Button)findViewById(R.id.button_add);
        AddData();
    }
    public void AddData()
    {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =myDb.insertData(editname.getText().toString(),
                        editsurname.getText().toString(),editmarks.getText().toString());
                if(isInserted==true)
                {
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
