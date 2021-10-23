package com.example.jokenp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int totalScorePlayer = 0;
    int totalScoreCPU = 0;

    public void selectedRock (View view) {
        this.comparingOptions("rock");
    }

    public void selectedPaper (View view) {
        this.comparingOptions("paper");
    }

    public void selectedScissors (View view) {
        this.comparingOptions("scissors");
    }

    public void comparingOptions (String userChoice) {
        String cpuChoiceSelected = this.generateCpuChoice();
        ImageView cpuImageResult = findViewById(R.id.cpuChoiceImageApp);
        TextView scorePlayer = findViewById(R.id.playerScore);
        TextView scoreCpu = findViewById(R.id.cpuScore);
        TextView message = findViewById(R.id.winnerMessage);

        switch (cpuChoiceSelected) {
            case "rock":
                cpuImageResult.setImageResource(R.drawable.rock);
                if (userChoice == "paper"){
                    totalScorePlayer += 1;
                    scorePlayer.setText(Integer.toString(totalScorePlayer));
                    message.setText("Você ganhou!");
                    break;
                } else if (userChoice == "scissors") {
                    totalScoreCPU += 1;
                    scoreCpu.setText(Integer.toString(totalScoreCPU));
                    message.setText("Você perdeu!");
                    break;
                } else {
                    message.setText("Empate!");
                    break;
                }


            case "paper":
                cpuImageResult.setImageResource(R.drawable.paper);
                if (userChoice == "scissors"){
                    totalScorePlayer += 1;
                    scorePlayer.setText(Integer.toString(totalScorePlayer));
                    message.setText("Você ganhou!");
                    break;
                } else if (userChoice == "rock") {
                    totalScoreCPU += 1;
                    scoreCpu.setText(Integer.toString(totalScoreCPU));
                    message.setText("Você perdeu!");
                    break;
                } else {
                    message.setText("Empate!");
                    break;
                }


            case "scissors":
                cpuImageResult.setImageResource(R.drawable.scissors);
                if (userChoice == "rock"){
                    totalScorePlayer += 1;
                    scorePlayer.setText(Integer.toString(totalScorePlayer));
                    message.setText("Você ganhou!");
                    break;
                } else if (userChoice == "paper") {
                    totalScoreCPU += 1;
                    scoreCpu.setText(Integer.toString(totalScoreCPU));
                    message.setText("Você perdeu!");
                    break;
                } else {
                    message.setText("Empate!");
                    break;
                }
        }
    }

    public String generateCpuChoice () {
        int randomChoice = new Random().nextInt(3);
        String[] arrayCpuChoice = {"rock", "paper", "scissors"};
        String cpuChoice = arrayCpuChoice[ randomChoice ];
        System.out.println(cpuChoice);
        return cpuChoice;
    }

    public void reset (View view) {
        ImageView cpuImageResult = findViewById(R.id.cpuChoiceImageApp);
        cpuImageResult.setImageResource(R.drawable.startcpuchoice);
        TextView scorePlayer = findViewById(R.id.playerScore);
        TextView scoreCpu = findViewById(R.id.cpuScore);
        totalScorePlayer = 0;
        totalScoreCPU = 0;
        scorePlayer.setText(Integer.toString(totalScorePlayer));
        scoreCpu.setText(Integer.toString(totalScoreCPU));
        TextView message = findViewById(R.id.winnerMessage);
        message.setText(" ");
    }
}