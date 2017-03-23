package com.example.noor.sanp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton roll;
    ImageView khelari;
    int diceval;
    ImageView dice;
    TextView khelariscore;
    TextView compscore;
    Random r = new Random();
    float unit = 100;
    float leftoff = 40;
    float top = 40;
    int khelari1=0;
    int totalkhelari =0;
    int comp = 0;
    int totalcomp =0;
    CharSequence ladder = "Here is the LADDER!";
    CharSequence snake = "OOPS! A Snake!";
    CharSequence khelarii= "PLAYER";
    CharSequence compp= "MACHINE";
    int time = Toast.LENGTH_SHORT;
    //int[][] ladders = new int[][];
    Context context = getApplicationContext();
    Toast t1 = Toast.makeText(context,ladder,time);
    Toast t2 = Toast.makeText(context,snake,time);
    Toast t3 = Toast.makeText(context,khelarii,time);
    Toast t4 = Toast.makeText(context,compp,time);
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            t1.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
            t2.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
            roll = (ImageButton) findViewById(R.id.clickr); //the image button when clicked rolls the dice
            dice = (ImageView) findViewById(R.id.pehli); //the randomly generated number view
            khelari = (ImageView) findViewById(R.id.pkhilari); //player1
            khelariscore = (TextView)findViewById(R.id.s1);
            khelariscore.setText(totalkhelari+"");
            compscore = (TextView)findViewById(R.id.s2);
            compscore.setText(totalcomp+"");
            roll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int n = 6 - 1 + 1;
                    int i = r.nextInt() % n;
                    diceval = 1 + i; //generating a random number from 1-6 when the roll number is clicked.
                    //according to the number that is generated the corresponding image is displayed.
                    if (diceval == 1) {
                        dice.setImageResource(R.drawable.dice1);
                    } else if (diceval == 2) {
                        dice.setImageResource(R.drawable.dice2);
                    } else if (diceval == 3) {
                        dice.setImageResource(R.drawable.dice3);
                    } else if (diceval == 4) {
                        dice.setImageResource(R.drawable.dice4);
                    } else if (diceval == 5) {
                        dice.setImageResource(R.drawable.dice5);
                    } else if (diceval == 6) {
                        dice.setImageResource(R.drawable.dice6);
                    }
                    //the two functions run until any one the player's score reaches 100
                    while (totalkhelari !=100 || totalcomp != 100)
                    {   t3.show();
                        position1();
                        t4.show();
                    positioncomp();}
                }

                /*FIRST ALGORITHM STARTS HERE*/

               /* public int position1()
                {
                    totalkhelari = khelari1 + diceval; //adds up the score of the human player such that its current score+ the dice value generated in order to display its current position
                    //the following if conditions are used to indicate ladders and snakes according to what the current score of the player is and the increases or decreases according to the indication of a snake or ladder
                    if (totalkhelari == 3)
                    {
                        totalkhelari = 51;
                    }
                    else if(totalkhelari == 6)
                    {
                        totalkhelari = 27;
                    }
                    else if(totalkhelari == 20)
                    {
                        totalkhelari = 70;
                    }
                    else if(totalkhelari == 36)
                    {
                        totalkhelari = 55;
                    }
                    else if(totalkhelari == 68)
                    {
                        totalkhelari = 98;
                    }
                    else if(totalkhelari == 63)
                    {
                        totalkhelari = 95;
                    }
                    else if(totalkhelari == 34)
                    {
                        totalkhelari = 1;
                    }
                    else if(totalkhelari == 25)
                    {
                        totalkhelari = 5;
                    }
                    else if(totalkhelari == 99)
                    {
                        totalkhelari = 69;
                    }
                    else if(totalkhelari == 87)
                    {
                        totalkhelari = 57;
                    }
                    else if(totalkhelari == 91)
                    {
                        totalkhelari = 61;
                    }
                    else if(totalkhelari == 65)
                    {
                        totalkhelari = 52;
                    }
                    //used to indicate the user about the ladder or snake using TOAST
                    if (totalkhelari == 6 || totalkhelari == 3 || totalkhelari == 36 || totalkhelari == 20 || totalkhelari == 63|| totalkhelari == 68) {
                        t1.show();
                    }
                    if (totalkhelari == 25 || totalkhelari == 34 || totalkhelari == 47 || totalkhelari == 65 || totalkhelari == 87|| totalkhelari == 99 || totalkhelari==91) {
                        t2.show();
                    }
                    return totalkhelari;


                }
                //function to calculate the score of the computer
                public int positioncomp()
                {
                    totalcomp = comp + diceval;
                    if (totalcomp == 3)
                    {
                        totalcomp = 51;
                    }
                    else if(totalcomp == 6)
                    {
                        totalcomp = 27;
                    }
                    else if(totalcomp == 20)
                    {
                        totalcomp = 70;
                    }
                    else if(totalcomp == 36)
                    {
                        totalcomp = 55;
                    }
                    else if(totalcomp == 68)
                    {
                        totalcomp = 98;
                    }
                    else if(totalcomp == 63)
                    {
                        totalcomp = 95;
                    }
                    else if(totalcomp == 34)
                    {
                        totalcomp = 1;
                    }
                    else if(totalcomp == 25)
                    {
                        totalcomp = 5;
                    }
                    else if(totalcomp == 99)
                    {
                        totalcomp = 69;
                    }
                    else if(totalcomp == 87)
                    {
                        totalcomp = 57;
                    }
                    else if(totalcomp == 91)
                    {
                        totalcomp = 61;
                    }
                    else if(totalcomp == 65)
                    {
                        totalcomp = 52;
                    }
                    if (totalcomp == 6 || totalcomp == 3 || totalcomp == 36 || totalcomp == 20 || totalcomp == 63|| totalcomp == 68) {
                        t1.show();
                    }
                    if (totalcomp == 25 || totalcomp == 34 || totalcomp == 47 || totalcomp == 65 || totalcomp == 87|| totalcomp == 99 || totalcomp==91) {
                        t2.show();
                    }
                    return totalcomp;
                }*/

    /*SECOND ALGORITHM*/
                //the current location of the player is set using the x(column) and y(row) value using the leftand top offset and the unit for each block(total image pixels /10)
                public void set_location(int x, int y) {

                    khelari.setX(leftoff + x * unit);
                    khelari.setY(top + y * unit);
                }
                //get the x values from 0-9(left-right)
                public int getcolumn() {
                    return (int) (khelari.getX() / unit);
                }
                //get the y value from 0-9(top to bottom)
                public int getrow() {
                    return (int) (khelari.getY() / unit);
                }

                public void moveright(int units) {
                    int column = getcolumn(); //get the current column of the player
                    if ((column + units) < 9) {
                        //units = dice value
                        //when the dice is rolled if the current location + the dice value is less than the total number of column in a row move that many units in the same row.
                        set_location(column + units, getrow());
                    } else {
                        //if the sum is greater move to the last column then the above row and the move the remaining units
                        set_location(9, getrow() - 1);
                        moveleft(units - column - 1);
                    }
                }
                //moving the player towards the left
                public void moveleft(int units) {
                    int column = getcolumn();
                    if ((column + units) > 0) {
                        set_location(column - units, getrow());
                    } else {
                        set_location(0, getrow() - 1);
                        moveright(column + units - 1);
                    }
                }

                public void moveobject() {
                    if (roweven() == true) {
                        //since every even row requires the player to move right therefore for every even row the player is required to move right.
                        moveright(diceval);
                    } else {
                        //if the current row is odd move left is called.
                        moveleft(diceval);
                    }
                }

                public boolean roweven() {
                    //check whether the current row is even or odd
                    int current = getrow();
                    if ((current % 2) == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });

        }
}
