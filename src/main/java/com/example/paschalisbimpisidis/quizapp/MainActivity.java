package com.example.paschalisbimpisidis.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getResults(View view) {
        boolean one = isAnswer1Correct();
        boolean two = isAnswer2Correct();
        boolean three = isAnswer3Correct();
        boolean four = isAnswer2Correct();
        boolean five = isAnswer2Correct();
        Log.v("MainActivity", "1st answer is: " + one + ", 2nd answer is: " + two + ", 3rd answer is: " + three + ", 4th answer is: " + four + ", 5th answer is: " + five);
    }

    private boolean isAnswer1Correct() {
        EditText input = findViewById(R.id.answer1);
        String answer1 = input.getText().toString();cdds

        return answer1.equals("5");
    }

    private boolean isAnswer2Correct() {
        RadioGroup answer2 = findViewById(R.id.question2);
        int selectedId = answer2.getCheckedRadioButtonId();
        RadioButton option2 = findViewById(R.id.answer2_2);

        return selectedId == option2.getId();
    }


}
