package com.example.zcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Zcaculator extends AppCompatActivity {

    private Spinner mSpinner;
    private EditText mTxtFirstNumber, mTxtSecondNumber;
    private TextView mTextResult, mTxtComment;

    private enum OperationType {
        Addition, Subtraction
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_zcaculator);
        mTxtFirstNumber = findViewById(R.id.txtFirstNumber);
        mTxtSecondNumber = findViewById(R.id.txtSecondNumber);
        mTextResult = findViewById(R.id.txtResult);
        mTxtComment = findViewById(R.id.txtComment);
        mSpinner = findViewById(R.id.operationSpinner);
        // sự kiện click button Result
        findViewById(R.id.btnGetResult).setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                OperationType operationType = OperationType.valueOf(mSpinner.getSelectedItem().toString());
                int num1 = Integer.parseInt(mTxtFirstNumber.getText().toString());
                int num2 = Integer.parseInt(mTxtSecondNumber.getText().toString());
                // show kết quả
                showResult(num1, num2, operationType);
            }
        });
    }

    //
    //  hàm results
    protected void showResult(int firstNumber, int secondNumber, OperationType type) {
        int resultVal = 0;
        if (type.equals(OperationType.Addition)) {
            resultVal = firstNumber + secondNumber;
        } else if (type.equals(OperationType.Subtraction)) {
            resultVal = firstNumber - secondNumber;
        }
        String operationResult = String.valueOf(resultVal);
        mTextResult.setText(operationResult);

        if (resultVal % 2 == 0) {
            mTxtComment.setText("Đây là số chẵn");
            Toast.makeText(this, "Đây là số chẵn", Toast.LENGTH_SHORT).show();
        } else {
            mTxtComment.setText("Đây là số lẻ");
            Toast.makeText(this, "Đây là số lẻ", Toast.LENGTH_SHORT).show();
        }
    }
}