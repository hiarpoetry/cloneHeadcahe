package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import Database.Level2Handler;

public class lvl3_Activity extends AppCompatActivity {

    Level2Handler db = new Level2Handler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl3_);

    }

    public void sendMessage(View view){

        //assign values
        EditText a1 = findViewById(R.id.ans1);
        String answer1 = a1.getText().toString();

        EditText a2 = findViewById(R.id.ans2);
        String answer2 = a2.getText().toString();

        EditText a3 = findViewById(R.id.ans3);
        String answer3 = a3.getText().toString();

        //validation
        if (TextUtils.isEmpty(answer1) || TextUtils.isEmpty(answer2) || TextUtils.isEmpty(answer3)){
            Toast warn = Toast.makeText(getApplicationContext(), "Enter Answers To Advance", Toast.LENGTH_LONG);
            warn.show();
        } //empty fields

        else if (checkAnswer(answer1) && checkAnswer(answer2) && checkAnswer(answer3)){
            Toast congrat = Toast.makeText(getApplicationContext(),"All Answers Are Successful! You May Advance To The Next Level!", Toast.LENGTH_LONG);
            congrat.show();
            //redirect to the next level
            Intent intent = new Intent(this , Level04.class);
            startActivity(intent);

        } //successful answers

        else {
            Toast fail = Toast.makeText(getApplicationContext(),"Incorrect Answers. Please Try Again To Advance To The Next Level.", Toast.LENGTH_LONG);
            fail.show();

            Intent intent = new Intent(this, lvl3_Activity.class); //redirect to the same level
            startActivity(intent);

        } //incorrect answers

    }

    //method to check answer
    public boolean checkAnswer(String answer){

        List<String> list =  db.readAnswers();

        for (String a : list){
            if(answer.equalsIgnoreCase(a))//compare
                return true;
        } //end of for loop

        return false;
    }//end of check answer method


}
