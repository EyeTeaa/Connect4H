package com.example.connect4h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

//    private String playerOneName = "";
//    private String playerTwoName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        //Intent intent = getIntent();
//        playerOneName = intent.getStringExtra(MainActivity.passingFirstName);
//        playerTwoName = intent.getStringExtra(MainActivity.passingSecondName);

        onButtonBackToHome();
    }

    private void onButtonBackToHome()
    {
        Button nextButton = (Button) findViewById(R.id.buttonBackToHome);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(EndScreen.this, HomeScreen.class));
            }
        });
    }


}