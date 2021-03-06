package com.example.connect4h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables that are used to pass info from one screen to another
//    public static final String passingFirstName = "com.example.application.Connect4H.passingFirstName";
//    public static final String passingSecondName = "com.example.application.Connect4H.passingSecondName";

    private ImageView[][] arrayOfCircleReferences = new ImageView[7][7];
    private dot[][] arrayOfDotProperties = new dot[7][7];

    //the column in which the user selected
    private int column = 0 ;

    //next free row indexes pertaining to the columns
    private int[] freeRowForColumn = {6,6,6,6,6,6,6};


    // -- all the player relevant variables
    private String playerOneName = "" ;
    private String playerTwoName = "" ;
    //holds the drawable references for each color of the circles
    private int playerOneChoice = R.drawable.redcircle;
    private int playerTwoChoice = R.drawable.yellowcircle;
    //handles the current stuff
    private boolean currentPlayer = true; //true = playerOne // false = playerTwo
    private int currentPlayerColor = R.drawable.graycircle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        playerOneName = intent.getStringExtra(HomeScreen.EXTRA_TEXT);
        playerTwoName = intent.getStringExtra(HomeScreen.EXTRA_TEXT2);

        populateArrayOfCircleReferences();
        onButtonEndGame();
    }

    //all the lines down from here would be for the row of buttons
    public void buttonCol1(View v)
    {
        column = 0 ;
        columnHasBeenClicked();
    }

    public void buttonCol2(View view)
    {
        column = 1  ;
        columnHasBeenClicked();
    }

    public void buttonCol3(View view )
    {
        column = 2 ;
        columnHasBeenClicked();
    }

    public void buttonCol4(View view )
    {
        column = 3 ;
        columnHasBeenClicked();
    }

    public void buttonCol5(View view )
    {
        column = 4 ;
        columnHasBeenClicked();
    }

    public void buttonCol6(View view )
    {
        column = 5 ;
        columnHasBeenClicked();
    }

    public void buttonCol7(View view )
    {
        column = 6 ;
        columnHasBeenClicked();
    }

    /* populates both of the 2D arrays
    arrayOfDotProperties and arrayOfCircleReferences
    */
    public void populateArrayOfCircleReferences()
    {
        TextView textPlayerTurn = (TextView) findViewById(R.id.textPlayerTurn);
        textPlayerTurn.setText( playerOneName + "'s Turn");
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

    }

    //this will return the corresponding images for the correct player
    public int getCorrespondingDot()
    {
        if (currentPlayer)
        {
            return playerOneChoice;
        }
        else
        {
            return playerTwoChoice;
        }
    };

    //sets everything up for the next player
    public void nextPlayerTurn()
    {
        String firstPlayerText = playerOneName +  "'s Turn";
        String secondPlayerText = playerTwoName + "'s Turn";
        currentPlayer = !currentPlayer;
        if (currentPlayer)
        {
            TextView textPlayerTurn = (TextView) findViewById(R.id.textPlayerTurn);
            textPlayerTurn.setText(firstPlayerText);
            currentPlayerColor = playerOneChoice;
        }
        else
        {
            TextView textPlayerTurn = (TextView) findViewById(R.id.textPlayerTurn);
            textPlayerTurn.setText(secondPlayerText);
            currentPlayerColor = playerTwoChoice;
        }

    }

    //this would run when a column button has been clicked
    public void columnHasBeenClicked()
    {
        //if statement to check if that column is full
        if (freeRowForColumn[column] != -1 )
        {
            arrayOfCircleReferences[freeRowForColumn[column ]][column].setImageResource(getCorrespondingDot());
            arrayOfDotProperties[freeRowForColumn[column]][column].setPopulated(currentPlayerColor);
            checkColumnForFour();
            checkRowForFour();
            freeRowForColumn[column] = freeRowForColumn[column] - 1 ;
            nextPlayerTurn();
        }
        else
        {
            Toast.makeText(this, "That column is full", Toast.LENGTH_SHORT).show();
        }
    }

    //would be called with each click and checks if there's four in a row
    public void checkRowForFour()
    {
        int valueOfCircle = arrayOfDotProperties[freeRowForColumn[column]][0].getPopulated();
        int valueInARow = 1;
        for (dot v : arrayOfDotProperties[freeRowForColumn[column]])
        {
            if(valueOfCircle == v.getPopulated() && v.getPopulated() != 0)
            {
                valueInARow++;
            }
            else if (v.getPopulated()!=0)
            {
                valueOfCircle = v.getPopulated();
                valueInARow = 1;
            }
            else
            {
                valueInARow = 0;
            }
            if (valueInARow == 4)
            {
                Toast.makeText(this, "this row is full"  + currentPlayer, Toast.LENGTH_SHORT).show();
            }
        }
    }

    //called with each click ad checks if there's four in a column
    public void checkColumnForFour()
    {
        int valueOfCircle = arrayOfDotProperties[6][column].getPopulated();
        int valueInARow = 0;

        for(int v = 6 ; v > -1 ; v-- )
        {
            if (arrayOfDotProperties[v][column].getPopulated() != 0)
            {
                if (arrayOfDotProperties[v][column].getPopulated() == valueOfCircle && arrayOfDotProperties[v][column].getPopulated() != 0)
                {
                    valueInARow++;
                } else if (arrayOfDotProperties[v][column].getPopulated() != 0) {

                    valueOfCircle = arrayOfDotProperties[v][column].getPopulated();
                    valueInARow = 1;
                } else
                {
                    valueInARow = 0;
                }
                if (valueInARow == 4)
                {
                    Toast.makeText(this, "the Column works" + currentPlayer, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }




    private void onButtonEndGame()
    {
        Button nextButton = (Button) findViewById(R.id.buttonEndGame);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, EndScreen.class));
            }
        });
    }








//https://stackoverflow.com/questions/34027200/android-studio-mass-imageview-array
    //https://stackoverflow.com/questions/2974862/changing-imageview-source
    //https://stackoverflow.com/questions/16906528/change-image-of-imageview-programmatically-in-android
}
