package com.example.connect4h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView[][] arrayOfCircles = new ImageView[7][7];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayOfCircles();
    }


    public void populateArrayOfCircles()
    {
        TextView textPlayerTurn = (TextView) findViewById(R.id.textPlayerTurn);
        textPlayerTurn.setText("Red Player's Turn:");
        //for (int i = 0; i < 26; i++) { //You might have to change that slightly depending on where you want to start/end counting
        //    int res = getResources().getIdentifier("i"+i, "id", getPackageName()); //This line is necessary to "convert" a string (e.g. "i1", "i2" etc.) to a resource ID
        //    letters[i] = (ImageView) findViewById(res);
        //    //setOnclicklistener for letters[i] and whatever you would like to do.
        //}
        int index = 1 ;
        for(int v = 0 ; v < 7 ; v ++ )
        {
            for (int n = 0; n < 7; n++)
            {
                int res = getResources().getIdentifier("dot" + index, "id", getPackageName());
                arrayOfCircles[v][n] = (ImageView) findViewById(res);
                arrayOfCircles[v][n].setImageResource(R.drawable.graycircle);
                index++;
            }
        }

    }

//https://stackoverflow.com/questions/34027200/android-studio-mass-imageview-array
    //https://stackoverflow.com/questions/2974862/changing-imageview-source
    //https://stackoverflow.com/questions/16906528/change-image-of-imageview-programmatically-in-android
}
