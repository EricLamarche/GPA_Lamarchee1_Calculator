package com.example.gpa_lamarchee1_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mathGrade;
    private EditText scienceGrade;
    private EditText historyGrade;
    private EditText englishGrade;
    private EditText programmingGrade;
    private Button compute;
    private TextView result;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ConstraintLayout constraintLayout;

        mathGrade = (EditText) findViewById(R.id.edtMathGrade);
        scienceGrade = (EditText) findViewById(R.id.edtScienceGrade);
        historyGrade = (EditText) findViewById(R.id.edtHistoryGrade);
        englishGrade = (EditText) findViewById(R.id.edtEnglishGrade);
        programmingGrade = (EditText) findViewById(R.id.edtProgrammingGrade);
        compute = (Button) findViewById(R.id.btnComputeGPA);
        result = (TextView) findViewById(R.id.txtGPA);
        result.setText("GPA: 0");
        constraintLayout = findViewById(R.id.back);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count % 2 == 0) {
                    if (mathGrade.getText().toString().equals("") || scienceGrade.getText().toString().equals("") || historyGrade.getText().toString().equals("") || englishGrade.getText().toString().equals("") || programmingGrade.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Error: Please fill in all fields", Toast.LENGTH_SHORT).show();

                    } else {
                        double number1 = Double.parseDouble(mathGrade.getText().toString());
                        double number2 = Double.parseDouble(scienceGrade.getText().toString());
                        double number3 = Double.parseDouble(historyGrade.getText().toString());
                        double number4 = Double.parseDouble(englishGrade.getText().toString());
                        double number5 = Double.parseDouble(programmingGrade.getText().toString());
                        double gpa = (number1 + number2 + number3 + number4 + number5) / 5;
                        result.setText("GPA: " + String.valueOf(gpa));

                        if (gpa >= 80 && gpa <= 100) {
                            constraintLayout.setBackgroundResource(R.color.green);
                        } else if (gpa > 60 && gpa < 80) {
                            constraintLayout.setBackgroundResource(R.color.yellow);
                        } else if (gpa < 60) {
                            constraintLayout.setBackgroundResource(R.color.red);
                        } else {
                            constraintLayout.setBackgroundResource(R.color.white);
                        }
                        Button btn = (Button) findViewById(R.id.btnComputeGPA);
                        btn.setText("Clear Form");
                    }

                }
            }

        });
    }
}





