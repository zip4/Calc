package com.example.pashulya.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //обьявляем все элементы на экране
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPnt, bAdd, bSub, bDiv, bMul, bCalc, bClr;
    TextView tv;

    //переменные
    char operation;
    double num1, num2;
    String currentNum = "";
    double result = 0;
    boolean chk = true;
    boolean firstChk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //находим TextView
        tv = (TextView) findViewById(R.id.tv);

        //находим все кнопки
        bClr = (Button) findViewById(R.id.buttonClear);
        b0 = (Button) findViewById(R.id.button0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        bPnt = (Button) findViewById(R.id.buttonPnt);
        bAdd = (Button) findViewById(R.id.buttonAdd);
        bSub = (Button) findViewById(R.id.buttonSub);
        bMul = (Button) findViewById(R.id.buttonMul);
        bDiv = (Button) findViewById(R.id.buttonDiv);
        bCalc = (Button) findViewById(R.id.buttonCalc);

        //присваиваем всем кнопка в качестве обработчика нажатий Activity
        bClr.setOnClickListener(this);
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bPnt.setOnClickListener(this);
        bAdd.setOnClickListener(this);
        bSub.setOnClickListener(this);
        bMul.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bCalc.setOnClickListener(this);


    }

    //Обработка нажатия каждой кнопки
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                tv.setText(tv.getText() + "0");
                currentNum = currentNum + "0";
                break;
            case R.id.button1:
                tv.setText(tv.getText() + "1");
                currentNum = currentNum + "1";
                break;
            case R.id.button2:
                tv.setText(tv.getText() + "2");
                currentNum = currentNum + "2";
                break;
            case R.id.button3:
                tv.setText(tv.getText() + "3");
                currentNum = currentNum + "3";
                break;
            case R.id.button4:
                tv.setText(tv.getText() + "4");
                currentNum = currentNum + "4";
                break;
            case R.id.button5:
                tv.setText(tv.getText() + "5");
                currentNum = currentNum + "5";
                break;
            case R.id.button6:
                tv.setText(tv.getText() + "6");
                currentNum = currentNum + "6";
                break;
            case R.id.button7:
                tv.setText(tv.getText() + "7");
                currentNum = currentNum + "7";
                break;
            case R.id.button8:
                tv.setText(tv.getText() + "8");
                currentNum = currentNum + "8";
                break;
            case R.id.button9:
                tv.setText(tv.getText() + "9");
                currentNum = currentNum + "9";
                break;
            case R.id.buttonPnt:
                tv.setText(tv.getText() + ".");
                currentNum = currentNum + ".";
                disablePoint();
                break;
            case R.id.buttonAdd:
                tv.setText(tv.getText() + "+");
                operation = '+';
                enablePoint();
                disableOperations();
                num1 = Double.parseDouble(currentNum);
                currentNum = "";
                break;
            case R.id.buttonSub:
                tv.setText(tv.getText() + "-");
                operation = '-';
                enablePoint();
                disableOperations();
                num1 = Double.parseDouble(currentNum);
                currentNum = "";
                break;
            case R.id.buttonMul:
                tv.setText(tv.getText() + "*");
                operation = '*';
                enablePoint();
                disableOperations();
                num1 = Double.parseDouble(currentNum);
                currentNum = "";
                break;
            case R.id.buttonDiv:
                tv.setText(tv.getText() + "/");
                operation = '/';
                enablePoint();
                disableOperations();
                num1 = Double.parseDouble(currentNum);
                currentNum = "";
                break;
            case R.id.buttonClear:
                chk = true;
                enableAll();
                tv.setText("");
                currentNum = "";
                break;
            case R.id.buttonCalc:
                num2 = Double.parseDouble(currentNum);
                currentNum = "";
                tv.setText("Calculation...");
                CalculateRes(num1, num2, operation);
                //new
                currentNum = String.valueOf(result);
                //end
                tv.setText(result+"");
                if (!chk) disableAll(); else enableOperations();
                break;
        }
    }

    //простые вычисления
    public void CalculateRes(double num1, double num2, char operation){
        result=0;
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                //проверка при делении на 0
                if (num2 == 0) {
                    chk = false;
                    Toast.makeText(MainActivity.this, "Divided by zero", Toast.LENGTH_SHORT).show();
                }
                result = num1 / num2;
                break;
            default:
                break;
        }
    }

    //все кнопки неактивны
    public void disableAll(){
        b0.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        bPnt.setEnabled(false);
        bAdd.setEnabled(false);
        bSub.setEnabled(false);
        bMul.setEnabled(false);
        bDiv.setEnabled(false);
        bCalc.setEnabled(false);
    }

    //неактивны кнопки операций
    public void disableOperations(){
        bAdd.setEnabled(false);
        bSub.setEnabled(false);
        bMul.setEnabled(false);
        bDiv.setEnabled(false);
    }

    //неактивна кнопка дроби
    public void disablePoint(){
        bPnt.setEnabled(false);
    }

    //неактивна кнопка равно
    public void disableCalc(){
        bCalc.setEnabled(false);
    }

    //активны кнопки операций
    public void enableAll(){
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        bPnt.setEnabled(true);
        bAdd.setEnabled(true);
        bSub.setEnabled(true);
        bMul.setEnabled(true);
        bDiv.setEnabled(true);
        bCalc.setEnabled(true);
    }

    //активны кнопки операций
    public void enableOperations(){
        bAdd.setEnabled(true);
        bSub.setEnabled(true);
        bMul.setEnabled(true);
        bDiv.setEnabled(true);
    }

    //активна кнопка дроби
    public void enablePoint(){
        bPnt.setEnabled(true);
    }

}
