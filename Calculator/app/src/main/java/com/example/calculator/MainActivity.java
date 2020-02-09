package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num;
    TextView result;
    Double operand = null;
    String lastOp = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.result);
    }

    public void onNumberClick(View v) {
        Button button = (Button) v;
        num.append(button.getText());
        if(lastOp.equals("=") && operand!=null){
            operand = null;
        }
    }

    public void onOperationClick(View v) {
        Button button = (Button) v;
        String op = button.getText().toString();
        String number = num.getText().toString();
        if(number.length()>0){
            DoOperation(Double.valueOf(number), op);
        }
        lastOp = op;
    }
    public void DoOperation(Double number,String operation){
        if(operand ==null){
            operand = number;
        }
        else{
            if(lastOp.equals("=")){
                lastOp = operation;
            }
            switch(lastOp){
                case "=":
                    operand =number;
                    break;
                case "/":
                    if(number==0){
                        operand =0.0;
                    }
                    else{
                        operand /=number;
                    }
                    break;
                case "*":
                    operand *=number;
                    break;
                case "+":
                    operand +=number;
                    break;
                case "-":
                    operand -=number;
                    break;
            }
        }
        result.setText(operand.toString());
        num.setText("");
    }
}
