package com.example.connect4h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeScreen extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.application.example.EXTRA_TEXT2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        onButtonPlay();
    }

    private void onButtonPlay()
    {
        Button nextButton = (Button) findViewById(R.id.buttonPlay);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openMainActivity();
            }
        });
    }

    public void openMainActivity()
    {
        EditText editText1 = (EditText) findViewById(R.id.inputPlayerOneName);
        String playerOneNameHold = editText1.getText().toString();
        if (playerOneNameHold.equals(""))
        {
            playerOneNameHold = "Player 1";
        }

        EditText editText2 = (EditText) findViewById(R.id.inputPlayerTwoName);
        String playerTwoNameHold = editText2.getText().toString();
        if(playerTwoNameHold.equals(""))
        {
            playerTwoNameHold = "Player 2";
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT, playerOneNameHold);
        intent.putExtra(EXTRA_TEXT2, playerTwoNameHold);
        startActivity(intent);
    }

}