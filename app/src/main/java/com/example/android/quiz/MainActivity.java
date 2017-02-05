package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int questionNumber = 1;
    final int NUMBER_OF_QUESTIONS = 4;

    final String QUESTION_ONE = "What device do we use to look at the stars?";
    final String QUESTION_TWO = "What are the three primary colors?";
    final String QUESTION_THREE = "What planet is nearest the sun?";
    final String Question_FOUR = "What is the lightest existing metal?";

    ScrollView answerOneLayout;
    ScrollView answerTwoLayout;
    ScrollView answerThreeLayout;
    ScrollView answerFourLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerOneLayout = (ScrollView) findViewById(R.id.answer_one_layout);
        answerTwoLayout = (ScrollView) findViewById(R.id.answer_two_layout);
        answerThreeLayout = (ScrollView) findViewById(R.id.answer_three_layout);
        answerFourLayout = (ScrollView) findViewById(R.id.answer_four_layout);
    }

    public void setQuestionNumber() {
        TextView questionNumberTextView = (TextView) findViewById(R.id.question_number_text_view);
        questionNumberTextView.setText("Question " + questionNumber + " of " + NUMBER_OF_QUESTIONS);
    }

    public void previousClicked(View v) {
        if (questionNumber > 1) {
            questionNumber -= 1;
            setQuestionNumber();
            setQuestion();
        } else {
            Toast.makeText(this, "This is the first question!", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextClicked(View v) {
        if (questionNumber < NUMBER_OF_QUESTIONS) {
            questionNumber += 1;
            setQuestionNumber();
            setQuestion();
        } else {
            Toast.makeText(this, "This is the last question!", Toast.LENGTH_SHORT).show();
        }
    }

    public void submitClicked(View v) {
        int correctAnswers = 0;

        EditText answerOneEditText = (EditText) findViewById(R.id.answer_one_edit_text);

        if (answerOneEditText.getText().toString().equals("Telescope")) {
            correctAnswers += 1;
        }

        CheckBox redCheckBox = (CheckBox) findViewById(R.id.red_check_box);
        CheckBox orangeCheckBox = (CheckBox) findViewById(R.id.orange_check_box);
        CheckBox yellowCheckBox = (CheckBox) findViewById(R.id.yellow_check_box);
        CheckBox greenCheckBox = (CheckBox) findViewById(R.id.green_check_box);
        CheckBox blueCheckBox = (CheckBox) findViewById(R.id.blue_check_box);
        CheckBox purpleCheckBox = (CheckBox) findViewById(R.id.purple_check_box);

        if (redCheckBox.isChecked() && !orangeCheckBox.isChecked() && yellowCheckBox.isChecked() && !greenCheckBox.isChecked() && blueCheckBox.isChecked() && !purpleCheckBox.isChecked()) {
            correctAnswers += 1;
        }

        RadioButton mercuryRadioButton = (RadioButton) findViewById(R.id.mercury_radio_button);

        if (mercuryRadioButton.isChecked()) {
            correctAnswers += 1;
        }

        EditText answerFourEditText = (EditText) findViewById(R.id.answer_four_edit_text);

        if (answerFourEditText.getText().toString().equals("Aluminum")) {
            correctAnswers += 1;
        }

        Toast.makeText(this, "You got " + correctAnswers + " out of " + NUMBER_OF_QUESTIONS + " correct!", Toast.LENGTH_LONG).show();
    }

    public void setQuestion() {
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);

        if (questionNumber == 1) {
            questionTextView.setText(QUESTION_ONE);

            answerOneLayout.setVisibility(View.VISIBLE);
            answerTwoLayout.setVisibility(View.GONE);
            answerThreeLayout.setVisibility(View.GONE);
            answerFourLayout.setVisibility(View.GONE);
        } else if (questionNumber == 2) {
            questionTextView.setText(QUESTION_TWO);

            answerOneLayout.setVisibility(View.GONE);
            answerTwoLayout.setVisibility(View.VISIBLE);
            answerThreeLayout.setVisibility(View.GONE);
            answerFourLayout.setVisibility(View.GONE);
        } else if (questionNumber == 3) {
            questionTextView.setText(QUESTION_THREE);

            answerOneLayout.setVisibility(View.GONE);
            answerTwoLayout.setVisibility(View.GONE);
            answerThreeLayout.setVisibility(View.VISIBLE);
            answerFourLayout.setVisibility(View.GONE);
        } else if (questionNumber == 4) {
            questionTextView.setText(Question_FOUR);

            answerOneLayout.setVisibility(View.GONE);
            answerTwoLayout.setVisibility(View.GONE);
            answerThreeLayout.setVisibility(View.GONE);
            answerFourLayout.setVisibility(View.VISIBLE);
        }
    }
}
