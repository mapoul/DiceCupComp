package com.example.dicecupcomp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int SECOND_ACTIVITY = 10248;
    private ArrayList<String> rollHistory = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public int rollDice(){
        double randomDouble = Math.random() * 6 + 1;
        int randomInt = (int) randomDouble;

        switch (randomInt){
            case 1:
                return R.drawable.diceone;
            case 2:
                return R.drawable.dicetwo;
            case 3:
                return R.drawable.dicethree;
            case 4:
                return R.drawable.dicefour;
            case 5:
                return R.drawable.dicefive;
            case 6:
                return R.drawable.dicesix;
        }
        return -1;
    }

    public void onClickRoll(View view){
        Spinner spinner = findViewById(R.id.spnDice);
        LinearLayout board = findViewById(R.id.board);
        board.removeAllViews();
        int numberOfDice = Integer.parseInt(spinner.getSelectedItem().toString());
        String roll = "";

        if(numberOfDice > 3){
            LinearLayout boardTwo = new LinearLayout(this);
            boardTwo.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout boardThree = new LinearLayout(this);
            boardThree.setOrientation(LinearLayout.HORIZONTAL);

            for (int i = 0; i < 3 ; i++) {
                ImageView imageView = new ImageView(this);
                int dice = rollDice();
                imageView.setImageResource(dice);
                boardTwo.addView(imageView);
                roll += "-" + dice;
            }
            board.addView(boardTwo);


            for (int i = 3; i < numberOfDice; i++) {
                ImageView imageView = new ImageView(this);
                int dice = rollDice();
                imageView.setImageResource(dice);
                boardThree.addView(imageView);
                roll += "-" + dice;

            }
            board.addView(boardThree);
            rollHistory.add(roll);
        }else {
            LinearLayout boardTwo = new LinearLayout(this);
            boardTwo.setOrientation(LinearLayout.HORIZONTAL);
            for (int i = 0; i < numberOfDice; i++) {
                ImageView imageView = new ImageView(this);
                int dice = rollDice();
                imageView.setImageResource(dice);
                boardTwo.addView(imageView);
                roll += "-" + dice;
            }
            board.addView(boardTwo);
            rollHistory.add(roll);
        }
    }

    public void onClickHistory(View view){
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putStringArrayListExtra("history", rollHistory);
        //startActivityForResult(intent, SECOND_ACTIVITY);
        startActivity(intent);
    }
}
