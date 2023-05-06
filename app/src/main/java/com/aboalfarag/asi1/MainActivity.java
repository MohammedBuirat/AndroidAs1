package com.aboalfarag.asi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    HashMap<String,String> equations;
    void fillEquations(){
        int x=1;
        equations=new HashMap<String,String>();
        equations.put("2 + 3 =?", "5");
        equations.put("4 + 7 =?", "11");
        equations.put("8 + 2 =?", "10");
        equations.put("10 + 6 =?", "16");
        equations.put("5 + 9 =?", "14");
        equations.put("12 - 5 =?", "7");
        equations.put("16 - 9 =?", "7");
        equations.put("20 - 3 =?", "17");
        equations.put("8 - 4 =?", "4");
        equations.put("11 + 5 =?", "16");
        equations.put("13 - 6 =?", "7");
        equations.put("18 - 8 =?", "10");
        equations.put("4 + 6 =?", "10");
        equations.put("15 - 7 =?", "8");
        equations.put("9 + 8 =?", "17");
        equations.put("14 - 9 =?", "5");
        equations.put("6 + 7 =?", "13");
        equations.put("12 - 3 =?", "9");
        equations.put("10 + 2 =?", "12");
        equations.put("11 - 5 =?", "6");
    }
    public void start(){
        Random rand=new Random();
        int index=rand.nextInt(20);
        String equation = (String) equations.keySet().toArray()[index];
        String ans=equations.get(equation);
        TextView eq=findViewById(R.id.equation_text);
        eq.setText(equation);
        Button opt1=findViewById(R.id.option1);
        Button opt2=findViewById(R.id.option2);
        Button opt3=findViewById(R.id.option3);
        Button opt4=findViewById(R.id.option4);
        int right=Integer.parseInt(ans);
        int option1=-1;
        int option2=-1;
        int option3=-1;
        while(option1==-1||option1==right){
            option1=rand.nextInt(21);
        }
        while(option2==-1||option2==right||option2==option1){
            option2=rand.nextInt(21);
        }
        while(option3==-1||option3==right||option3==option1||option3==option2){
            option3=rand.nextInt(21);
        }
        index=rand.nextInt(4)+1;
        if(index==1){
            opt1.setText(ans);
            opt2.setText(Integer.toString(option1));
            opt3.setText(Integer.toString(option2));
            opt4.setText(Integer.toString(option3));
        }
        else if(index==2){
            opt2.setText(ans);
            opt1.setText(Integer.toString(option1));
            opt3.setText(Integer.toString(option2));
            opt4.setText(Integer.toString(option3));
        }
        else if(index==3){
            opt3.setText(ans);
            opt2.setText(Integer.toString(option1));
            opt1.setText(Integer.toString(option2));
            opt4.setText(Integer.toString(option3));
        }
        else{
            opt4.setText(ans);
            opt2.setText(Integer.toString(option1));
            opt3.setText(Integer.toString(option2));
            opt1.setText(Integer.toString(option3));
        }
    }
    public void chose(Button btn){
        Button opt1=findViewById(R.id.option1);
        Button opt2=findViewById(R.id.option2);
        Button opt3=findViewById(R.id.option3);
        Button opt4=findViewById(R.id.option4);
        TextView eq=findViewById(R.id.equation_text);
        TextView result=findViewById(R.id.result_text);
        opt1.setEnabled(false);
        opt2.setEnabled(false);
        opt3.setEnabled(false);
        opt4.setEnabled(false);
        CharSequence buttonText=btn.getText();
        String ans=buttonText.toString();
        String equation=eq.getText().toString();
        if(equations.get(equation)==ans){
            result.setVisibility(View.VISIBLE);
            result.setText("You are Correct (:");
            result.setTextColor(getResources().getColor(R.color.green));
        }
        else{
            result.setVisibility(View.VISIBLE);
            result.setText("You are Wrong ):");
            result.setTextColor(getResources().getColor(R.color.red));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillEquations();
        start();
        Button opt1=findViewById(R.id.option1);
        Button opt2=findViewById(R.id.option2);
        Button opt3=findViewById(R.id.option3);
        Button opt4=findViewById(R.id.option4);
        TextView result=findViewById(R.id.result_text);
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(opt1);
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(opt2);
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(opt3);
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(opt4);
            }
        });
        Button playAgain=findViewById(R.id.play_againbtn);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setVisibility(View.INVISIBLE);
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true);
                start();

            }
        });




    }
}