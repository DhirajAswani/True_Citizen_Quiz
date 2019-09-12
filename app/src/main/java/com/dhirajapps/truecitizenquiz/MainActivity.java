package com.dhirajapps.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button falseButton;
    private Button trueButton;
    private TextView questionTextView;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private int currentQuestionIndex = 0;
    private Question[] questionBank = new Question[]{
            new Question(R.string.question_amendments,false),
            new Question(R.string.question_constitution,true),
            new Question(R.string.question_declaration,true),
            new Question(R.string.question_independence_rights,true),
            new Question(R.string.question_religion,true),
            new Question(R.string.question_government,false),
            new Question(R.string.question_government_feds,false),
            new Question(R.string.question_government_senators,false),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Question question = new Question(R.string.question_declaration, true);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.answer_text_view);
        prevButton = findViewById(R.id.prev_button);

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(false);
//                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(true);
//                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
              updateQuestion();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionIndex > 0)
                {
                    currentQuestionIndex = (currentQuestionIndex - 1)% questionBank.length;
                    updateQuestion();
                }
                

            }
        });




    }

    private void updateQuestion()
    {
//        Toast.makeText(MainActivity.this, ""+questionBank[currentQuestionIndex].getAnswerId(), Toast.LENGTH_SHORT).show();
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerId());
//                Log.d("error",);
//                currentQuestionIndex++;
    }

    private void checkAns(boolean userChooseCorrect)
    {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId = 0;
        if(userChooseCorrect == answerIsTrue)
        {
            toastMessageId = R.string.correct_answer;
        }
        else
        {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this,toastMessageId, Toast.LENGTH_SHORT).show();
    }


}
