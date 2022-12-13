package com.example.calculatorclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    EditText calculo;
    String number="", operator="", firstNum="";
    double result=0.0;
    boolean newOperator = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        InicializarControles();
    }

    private void InicializarControles() {
       calculo = (EditText)findViewById(R.id.txtCalculos);
       number = calculo.getText().toString();
    }

    public void numberEvent(View view){

        if(newOperator)
            calculo.setText("");
        newOperator = false;

        switch (view.getId()) {
            case R.id.btnOne:
                number += "1";
                break;
            case R.id.btnTwo:
                number += "2";
                break;
            case R.id.btnThree:
                number += "3";
                break;
            case R.id.btnFour:
                number += "4";
                break;
            case R.id.btnFive:
                number += "5";
                break;
            case R.id.btnSix:
                number += "6";
                break;
            case R.id.btnSeven:
                number += "7";
                break;
            case R.id.btnEight:
                number += "8";
                break;
            case R.id.btnNine:
                number += "9";
                break;
            case R.id.btnCero:
                number += "0";
                break;
            case R.id.btnDot:
                number += ".";
                break;
            default:
                Toast.makeText(getApplicationContext(), "No ha ingresado algun digito valido", Toast.LENGTH_LONG).show();
        }
        calculo.setText(number);
    }

    public void operatorEvent(View view){
        newOperator =true;
        firstNum = number;

        switch (view.getId()) {
            case R.id.btnDivide:
                operator += "/";
                break;
            case R.id.btnMinus:
                operator += "-";
                break;
            case R.id.btnMultiply:
                operator += "*";
                break;
            case R.id.btnPlus:
                operator += "+";
                break;
            case R.id.btnPercent:
                operator += "%";
                break;
            default:
                Toast.makeText(getApplicationContext(), "No ha ingresado algun operador valido", Toast.LENGTH_LONG).show();
        }

        calculo.setText(operator);
    }

    public void deleteEvent(View view) {
        newOperator = true;

        if(calculo.getText().toString().length()!=0){
            calculo.setText((calculo.getText().toString().substring(0,calculo.getText().toString().length()-1)));
            
        }

    }

    public void clearEvent(View view) {
        number = "";
        firstNum = "";
        calculo.setText("");
        newOperator = true;
    }

    public void equalEvent(View view){
        newOperator = true;
        firstNum = number;
        switch (operator) {
            case "/":
                result = Double.parseDouble(firstNum) / Double.parseDouble(number);
                break;
            case "-":
                result = Double.parseDouble(firstNum) - Double.parseDouble(number);
                break;
            case "*":
                result = Double.parseDouble(firstNum) * Double.parseDouble(number);
                break;
            case "+":
                result = Double.parseDouble(firstNum) + Double.parseDouble(number);
                break;
            case "%":
                result = Double.parseDouble(firstNum) % Double.parseDouble(number);
                break;
            default:
                Toast.makeText(getApplicationContext(), "No es posible realizar esta operacion", Toast.LENGTH_LONG).show();
        }

    }
}



