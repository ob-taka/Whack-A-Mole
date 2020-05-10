package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3;
    TextView score;
    int totalScore;

    public MainActivity() {
        super();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("#g", "created");

        btn_1 = (Button) findViewById(R.id.myBtn_1);
        btn_2 = (Button) findViewById(R.id.myBtn_2);
        btn_3 = (Button) findViewById(R.id.myBtn_3);
        score = (TextView) findViewById(R.id.myTextView);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = (String) btn_1.getText();
                totalScore = Integer.parseInt(score.getText().toString());
                if (result.equals("*")){
                    totalScore += 1;
                    score.setText(String.valueOf(totalScore));
                    Log.d("#g", "Button right clicked! Hit, score added!");
                }
                else {
                    totalScore -= 1;
                    score.setText(String.valueOf(totalScore));
                    Log.d("#g", "Button right clicked! Missed, score deducted!");
                }
                swap(btn_1,btn_2,btn_3);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = (String) btn_2.getText();
                totalScore = Integer.parseInt(score.getText().toString());
                if (result.equals("*")){
                    totalScore += 1;
                    score.setText(String.valueOf(totalScore));
                    Log.d("#g", "Button Middle clicked! Hit, score added!");
                }
                else {
                    totalScore -= 1;
                    score.setText(String.valueOf(totalScore));
                    Log.d("#g", "Button right clicked! Missed, score deducted!");
                }
                swap(btn_1,btn_2,btn_3);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = (String) btn_3.getText();
                totalScore = Integer.parseInt(score.getText().toString());
                if (result.equals("*")){
                    totalScore += 1;
                    score.setText(String.valueOf(totalScore));
                    Log.d("#g", "Button Left clicked! Hit, score added!");
                }
                else {
                    totalScore -= 1;
                    score.setText(String.valueOf(totalScore));
                    Log.d("#g", "Button Left clicked! Missed, score deducted!");
                }
                swap(btn_1,btn_2,btn_3);
            }
        });
    }



    private void swap(Button x, Button y, Button z){
        String a,b,c;
        a = x.getText().toString();
        b = y.getText().toString();
        c = z.getText().toString();
        String[] list = {a,b,c};
        Random rnd = new Random();
        for(int i = list.length -1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            String d = list[index];
            list[index] = list[i];
            list[i] = d;
        }

        x.setText(list[0]);
        y.setText(list[1]);
        z.setText(list[2]);

    }
}
