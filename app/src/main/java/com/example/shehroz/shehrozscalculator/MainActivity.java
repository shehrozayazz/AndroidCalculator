package com.example.shehroz.shehrozscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String runningNumber="";
    TextView textView;
    static String zz=Character.toString((char)247);
     String  result="";
    public enum Operation{
        ADD,SUB,MUL,DIV,EQUAL
    }
    Operation currentOperation;
    String leftVal="";
    String rightVal="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1= findViewById(R.id.button1);
        Button button2= findViewById(R.id.button2);
        Button button3= findViewById(R.id.button3);
        Button button4= findViewById(R.id.button4);
        Button button5= findViewById(R.id.button5);
        Button button6= findViewById(R.id.button6);
        Button button7= findViewById(R.id.button7);
        Button button8= findViewById(R.id.button8);
        Button button9= findViewById(R.id.button9);
        Button button0= findViewById(R.id.button0);
        Button buttonClear= findViewById(R.id.buttonClear);
        Button buttonEqual= findViewById(R.id.buttonEqual);
        Button buttonAdd= findViewById(R.id.buttonAdd);
        Button buttonSub= findViewById(R.id.buttonSub);
        Button buttonMul= findViewById(R.id.buttonMul);
        Button buttonDiv= findViewById(R.id.buttonDiv);
        textView= findViewById(R.id.textView);
        textView.setText("");
        buttonDiv.setText(zz);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);

            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);

            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessOperation(Operation.DIV);

            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessOperation(Operation.SUB);


            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessOperation(Operation.ADD);


            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessOperation(Operation.MUL);


            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ProcessOperation(Operation.EQUAL);

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftVal="";
                rightVal="";
                runningNumber="";
                currentOperation=null;
                textView.setText("0");
                result="";

            }
        });

    }
    void ProcessOperation(Operation oper){
        if(currentOperation!=null){
            if(runningNumber!=""){
                rightVal=runningNumber;
                runningNumber="";
                switch (currentOperation){
                    case ADD:{
                        double a=Double.parseDouble(leftVal)+ Double.parseDouble(rightVal);
                        result=Double.toString(a);
                        result=String.format ("%.2f", a);
                        break;}
                    case DIV:{
                        if (Integer.parseInt(rightVal)==0){
                            Toast.makeText(MainActivity.this,
                                    " DIVIDED BY ZERO ERROR!!", Toast.LENGTH_LONG).show();

                        }
                        else{
                               if (leftVal==""){
                                   result=rightVal;

                               }
                               else {
                                   double a = Double.parseDouble(leftVal) / Double.parseDouble(rightVal);
                                   result = Double.toString(a);
                                   result = String.format("%.2f", a);
                               }
                            }

                        break;}
                    case MUL:{
                        double a=Double.parseDouble(leftVal)* Double.parseDouble(rightVal);
                        result=Double.toString(a);
                        result=String.format ("%.2f", a);
                        break;}
                    case SUB:{
                        double a=Double.parseDouble(leftVal)- Double.parseDouble(rightVal);
                        result=Double.toString(a);
                        result=String.format ("%.2f", a);
                        break;}

                }
                leftVal=String.valueOf(result);
                textView.setText(leftVal);
            }
            currentOperation=oper;

        }else{
            leftVal=runningNumber;
            runningNumber="";
        }
        currentOperation=oper;

    }


    void numberPressed(int number){
        runningNumber+=String.valueOf(number);
        textView.setText(runningNumber);

           }

}
