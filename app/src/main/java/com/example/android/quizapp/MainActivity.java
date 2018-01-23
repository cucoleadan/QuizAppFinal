package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This Method calculates the final Score

    private int finalScore() {

        int score = 0;
        RadioButton answerQ1 = findViewById(R.id.q1C);
        RadioButton answerQ2 = findViewById(R.id.q2A);
        RadioButton answerQ3 = findViewById(R.id.q3B);
        RadioButton answerQ4 = findViewById(R.id.q4C);
        RadioButton answerQ5 = findViewById(R.id.q5A);
        RadioButton answerQ6 = findViewById(R.id.q6D);
        RadioButton answerQ7 = findViewById(R.id.q7A);
        CheckBox firstAnswerQ8 = findViewById(R.id.q8A);
        CheckBox secondAnswerQ8 = findViewById(R.id.q8C);
        EditText rightAnswerQ9 = findViewById(R.id.q9_answer);
        boolean isCorrectQ1 = answerQ1.isChecked();
        boolean isCorrectQ2 = answerQ2.isChecked();
        boolean isCorrectQ3 = answerQ3.isChecked();
        boolean isCorrectQ4 = answerQ4.isChecked();
        boolean isCorrectQ5 = answerQ5.isChecked();
        boolean isCorrectQ6 = answerQ6.isChecked();
        boolean isCorrectQ7 = answerQ7.isChecked();
        boolean isCorrectQ8A = firstAnswerQ8.isChecked();
        boolean isCorrect8B = secondAnswerQ8.isChecked();
        String answerToQuestion9 = rightAnswerQ9.getText().toString();

        //The following if statements add a point to the score if the correct Radio Button has been pressed

        if (isCorrectQ1) {
            score++;
        }

        if (isCorrectQ2) {
            score++;
        }

        if (isCorrectQ3) {
            score++;
        }

        if (isCorrectQ4) {
            score++;
        }

        if (isCorrectQ5) {
            score++;
        }

        if (isCorrectQ6) {
            score++;
        }

        if (isCorrectQ7) {
            score++;
        }

        //The following if statement adds one to the score if both Check Boxes have been pressed

        if (isCorrectQ8A && isCorrect8B) {
            score++;
        }

        //The following if statement adds one to the score if the text that was imputed equals "3" or "three"

        if ( answerToQuestion9.equals("3") || answerToQuestion9.equals("three")) {
            score++;
        }

        return score;
    }


    public void getTheScore(View view) {

        int score = finalScore();
        EditText givenName = findViewById(R.id.name);
        String usersName = givenName.getText().toString();

        if (score == 9) {

            Context context = getApplicationContext();
            CharSequence text = usersName + getString(R.string.exclamation_mark) + getString(R.string.all_correct) + "\n" + getString(R.string.you_got) + score + getString(R.string.points);
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        } else if (score < 9 && score > 3) {
            Context context = getApplicationContext();
            CharSequence text = usersName + getString(R.string.exclamation_mark) + getString(R.string.half) + "\n" + getString(R.string.you_got) + score + getString(R.string.points);
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        } else {
            Context context = getApplicationContext();
            CharSequence text = usersName + getString(R.string.exclamation_mark) + getString(R.string.almost_none) + "\n" + getString(R.string.you_got) + score + getString(R.string.points);
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }

    }


}
