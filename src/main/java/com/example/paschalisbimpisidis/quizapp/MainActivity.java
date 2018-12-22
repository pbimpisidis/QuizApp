package com.example.paschalisbimpisidis.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getResults(View view) {
        int points = 0;
        boolean isAnswer1Correct = answer1();
        boolean isAnswer2Correct = answer2();
        boolean isAnswer3Correct = answer3();
        boolean isAnswer4Correct = answer4();
        boolean isAnswer5Correct = answer5();

        if (isAnswer1Correct)
            points += 1;
        if (isAnswer2Correct)
            points += 1;
        if (isAnswer3Correct)
            points += 1;
        if (isAnswer4Correct)
            points += 1;
        if (isAnswer5Correct)
            points += 1;

        displayResult(points);
    }

    private void displayResult(int points) {

        String scoreMessage = "Result: " + points + " out of 5!\n";
        String successMessage = displaySuccessMessage();
        String failMessage = displayFailMessage();

        if (points == 5)
            Toast.makeText(this, scoreMessage + successMessage, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, scoreMessage + failMessage, Toast.LENGTH_LONG).show();
    }

    private String displaySuccessMessage() {
        return getString(R.string.successMessage);

    }

    private String displayFailMessage() {
        return getString(R.string.failMessage);

    }

    private boolean answer1() {
        EditText input = findViewById(R.id.answer1);
        String answer1 = input.getText().toString();

        return answer1.equals("5");
    }

    private boolean answer2() {
        RadioGroup answer2 = findViewById(R.id.answer2);
        int selectedAnswerId = answer2.getCheckedRadioButtonId();
        RadioButton correctAnswer = findViewById(R.id.answer2_2);

        return selectedAnswerId == correctAnswer.getId();
    }

    private boolean answer3() {
        RadioGroup answer3 = findViewById(R.id.answer3);
        int selectedAnswerId = answer3.getCheckedRadioButtonId();
        RadioButton correctAnswer = findViewById(R.id.answer3_3);

        return selectedAnswerId == correctAnswer.getId();
    }

    private boolean answer4() {
        CheckBox answer4_1 = findViewById(R.id.answer4_1);
        CheckBox answer4_2 = findViewById(R.id.answer4_2);
        CheckBox answer4_3 = findViewById(R.id.answer4_3);
        CheckBox answer4_4 = findViewById(R.id.answer4_4);

        return (!answer4_1.isChecked() && answer4_2.isChecked() && answer4_3.isChecked() && !answer4_4.isChecked());
    }

    private boolean answer5() {
        RadioGroup answer5 = findViewById(R.id.answer5);
        int selectedAnswerId = answer5.getCheckedRadioButtonId();
        RadioButton correctAnswer = findViewById(R.id.answer5_1);

        return selectedAnswerId == correctAnswer.getId();
    }

}
