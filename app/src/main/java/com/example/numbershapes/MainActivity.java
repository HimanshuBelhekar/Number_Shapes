package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{

        int num;

        public boolean isTriangular(){
            if (num<=0){
                return false;
            }
            int sum = 0,n=1;
            while(sum<num){
                sum += n;
                n++;
                if(sum==num){
                    return true;
                }
            }
            return false;
        }

        public boolean isSquare(){
            double sr = Math.sqrt(num);

            return((sr - Math.floor(sr))==0);
        }
    }


    public void checkFunction(View view){

        Number number = new Number();
        String message;

        EditText editNum = (EditText) findViewById(R.id.editNumber);

        if(editNum.getText().toString().isEmpty()){
            message = "Please enter a number";
        } else {
            number.num = Integer.parseInt(editNum.getText().toString());

            boolean sq = number.isSquare();
            boolean tri = number.isTriangular();

            if (sq == tri) {
                if (sq) {
                    message = "The number is both square and triangular";
                } else {
                    message = "The number is neither square nor triangular";
                }
            } else {
                if (sq) {
                    message = "The number is square";
                } else {
                    message = "The number is triangular";
                }
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}