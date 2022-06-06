package com.example.connect4h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView[][] arrayOfCircleReferences = new ImageView[7][7];
    private dot[][] arrayOfDotProperties = new dot[7][7];

    //the column in which the user selected
    private int column = 0 ;

    //next free row indexes pertaining to the columns
    private int[] freeRowForColumn = {6,6,6,6,6,6,6};


    //holds the drawable references for each color of the circles
    private int playerOneChoice = R.drawable.redcircle;
    private int playerTwoChoice = R.drawable.yellowcircle;
    private int currentPlayerColor = R.drawable.graycircle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayOfCircleReferences();
    }

    public void buttonCol1(View v)
    {
        column = 0 ;
        //if statement to check if that column is full
        if (freeRowForColumn[column] != 0 )
        {
            arrayOfCircleReferences[freeRowForColumn[column ]][column].setImageResource(R.drawable.redcircle);
        }
        else
        {

        }
        TextView textPlayerTurn = (TextView) findViewById(R.id.textPlayerTurn);
        textPlayerTurn.setText("The button has been clicked");
    }

    public void buttonCol2(View view)
    {
        TextView textPlayerTurn = (TextView) findViewById(R.id.textPlayerTurn);
        textPlayerTurn.setText("brocken");
        column = 1  ;
    }

    public void buttonCol3(View view )
    {
        column = 2 ;
    }

    public void buttonCol4(View view )
    {
        column = 3 ;
    }

    public void buttonCol5(View view )
    {
        column = 4 ;
    }

    public void buttonCol6(View view )
    {
        column = 5 ;
    }

    public void buttonCol7(View view )
    {
        column = 6 ;
    }

    /* populates both of the 2D arrays
    arrayOfDotProperties and arrayOfCircleReferences
    */
    public void populateArrayOfCircleReferences()
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
                dot newDot = new dot(0);
                arrayOfDotProperties[v][n] = newDot;
                int res = getResources().getIdentifier("dot" + index, "id", getPackageName());
                arrayOfCircleReferences[v][n] = (ImageView) findViewById(res);
                arrayOfCircleReferences[v][n].setImageResource(R.drawable.graycircle);
                index++;
            }
        }
        arrayOfCircleReferences[0][5].setImageResource(R.drawable.yellowcircle);

    }

    public int getCorrespondingColors(int b)
    {
        //if ()
        return 0 ;
    };


//https://stackoverflow.com/questions/34027200/android-studio-mass-imageview-array
    //https://stackoverflow.com/questions/2974862/changing-imageview-source
    //https://stackoverflow.com/questions/16906528/change-image-of-imageview-programmatically-in-android
}
