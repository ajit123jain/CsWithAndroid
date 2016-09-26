package com.google.engedu.ghost;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;


public class GhostActivity extends AppCompatActivity {
    private static final String COMPUTER_TURN = "Computer's turn";
    private static final String USER_TURN = "Your turn";
    private GhostDictionary dictionary;
//    private SimpleDictionary simple_fast_dictionary;
    private FastDictionary simple_fast_dictionary;
    private boolean userTurn = false;
    private Random random = new Random();
    private InputStream is =null;
    private TextView tvGhostText,label;
    private Button bChallenge,bRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost);
        tvGhostText = (TextView)findViewById(R.id.ghostText);
        label = (TextView)findViewById(R.id.gameStatus);
        bChallenge = (Button)findViewById(R.id.bChallenge);
        bRestart =(Button)findViewById(R.id.bRestart);

        bChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChallengeMethod();
            }
        });
        bRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestartMethod();
            }
        });
        try {
            is = getAssets().open("words.txt");
            simple_fast_dictionary=new FastDictionary(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        AssetManager assetManager = getAssets();
//        try {
//            InputStream inputStream = assetManager.open("words.txt");
//            dictionary = new FastDictionary(inputStream);
//        } catch (IOException e) {
//            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
//            toast.show();
//        }
        onStart(null);
    }
    public void ChallengeMethod()

    {
        String text = tvGhostText.getText().toString();
        String nextWord;
        if (text.length() >= 4 && dictionary.isWord(text)){
            Toast.makeText(GhostActivity.this, "You Wins", Toast.LENGTH_SHORT).show();
        } else {
             String word=simple_fast_dictionary.getAnyWordStartingWith(text);
            if(word!=null){
                Toast.makeText(this, "Computer Wins. Word is "+ word , Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "You Wins", Toast.LENGTH_SHORT).show();
            }
    }
    }

    public void RestartMethod()
    {
        onStart(null);


    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        char keypressed = (char) event.getUnicodeChar();
       if(keypressed>=97 && keypressed <=122){
           String currentText = tvGhostText.getText().toString();
           tvGhostText.setText(currentText + keypressed);
           label.setText(COMPUTER_TURN);
            computerTurn();
           return true;
        } else {
            (Toast.makeText(this, "Please enter a valid character between a-z only", Toast.LENGTH_LONG)).show();
        }
        return super.onKeyUp(keyCode, event);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ghost, menu);
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

    /**
     * Handler for the "Reset" button.
     * Randomly determines whether the game starts with a user turn or a computer turn.
     * @param view
     * @return true
     */
    public boolean onStart(View view) {
        userTurn = random.nextBoolean();
        TextView text = (TextView) findViewById(R.id.ghostText);
        text.setText("");
        TextView label = (TextView) findViewById(R.id.gameStatus);
        if (userTurn) {
            label.setText(USER_TURN);
        } else {
            label.setText(COMPUTER_TURN);
            computerTurn();
        }
        return true;
    }

    private void computerTurn() {
        String temp_text = tvGhostText.getText().toString();
        if(temp_text.length()>=4 && simple_fast_dictionary.isWord(temp_text)){

            Toast.makeText(GhostActivity.this, "Computer Wins", Toast.LENGTH_SHORT).show();
            label.setText("Restart!");
        }
        else
        {
            String word = simple_fast_dictionary.getAnyWordStartingWith(temp_text);
            if(word == null){
                Toast.makeText(GhostActivity.this,"Computer Wins",Toast.LENGTH_SHORT).show();
                label.setText("Restart!");
            }
            else{
                temp_text = temp_text +word.charAt(temp_text.length());
                tvGhostText.setText(temp_text);
            }
        }
        userTurn = true;
        label.setText(USER_TURN);
    }
}
