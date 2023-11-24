package com.example.savchenko_calculator;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv,solutionTv;
    MaterialButton buttonC;
    MaterialButton buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEquals, buttonPlusMinus, buttonRoot, buttonPow;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);
        assignId(buttonPlusMinus,R.id.button_plus_minus);
        assignId(buttonRoot,R.id.button_square_root);
        assignId(buttonC,R.id.button_c);
        assignId(buttonDivide,R.id.button_divide);
        assignId(buttonMultiply,R.id.button_multiply);
        assignId(buttonPlus,R.id.button_plus);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonEquals,R.id.button_equals);
        assignId(button0,R.id.button_0);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
        assignId(buttonAC,R.id.button_ac);
        assignId(buttonDot,R.id.button_dot);
        assignId(buttonPow,R.id.button_pow);





    }

    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    boolean isNegative = false;
    boolean signPresent = false;
    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();
        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        else if(buttonText.equals("÷")){
            dataToCalculate = dataToCalculate + "/";
        }
        else if (buttonText.equals("×")) {
            dataToCalculate = dataToCalculate + "*";
        }
        else if(buttonText.equals("√")){

            dataToCalculate = dataToCalculate + "√";
        }
        else if(buttonText.equals("^")){

            dataToCalculate = dataToCalculate + "^";
        }
        else if(buttonText.equals("=")){

            solutionTv.setText(dataToCalculate);
            String userExp = solutionTv.getText().toString();
            Expression exp = new Expression (userExp);
            String result = String.valueOf(exp.calculate());
            resultTv.setText(result);
            return;
        }
        else if(buttonText.equals("C")){
            if(resultTv.getText().length()!=1)
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            else {
                solutionTv.setText("");
                resultTv.setText("0");
                return;
            }
        }
        else if(buttonText.equals("+/-"))
        {
            dataToCalculate = isNegative ? dataToCalculate.substring(1) : "-" + dataToCalculate;
            isNegative = !isNegative;
        }
        else{
            dataToCalculate = dataToCalculate+buttonText;
        }
        solutionTv.setText(dataToCalculate);
        String userExp = solutionTv.getText().toString();

        Expression exp = new Expression (userExp);

        String result = String.valueOf(exp.calculate());

        resultTv.setText(result);

    }

}
