package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity{
    Button[] btn = new Button[10];
    Button plus,sub,result,mul,div,rem,clear,margin;
    TextView tv;
    String res = "";
    Double first_num,second_num;
    boolean turn = true;
    int check = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        for(int i=0; i<btn.length; i++){
            btn[i] = findViewById(R.id.btn0 +i);
            btn[i].setOnClickListener(num);
        }
        tv = findViewById(R.id.board_tv);

        plus = findViewById(R.id.plus);
        sub = findViewById(R.id.sub);
        result = findViewById(R.id.result);
        mul = findViewById(R.id.mul);
        div =findViewById(R.id.div);
        clear = findViewById(R.id.clear);
        rem = findViewById(R.id.remain);
        margin = findViewById(R.id.margin);

        plus.setOnClickListener(calc);
        sub.setOnClickListener(calc);
        result.setOnClickListener(calc);
        mul.setOnClickListener(calc);
        div.setOnClickListener(calc);
        clear.setOnClickListener(calc);
        rem.setOnClickListener(calc);
        margin.setOnClickListener(calc);

        set_clear();
    }

    private void set_clear(){
        res = "";
        turn = true;
        first_num = null;
        second_num = null;
        check = -1;
        tv.setText("0.0");
    }

    private Double get_result(){
        Double answer = null;
        switch (check){
            case 1:
                answer = first_num+second_num;
                break;
            case 2:
                answer = first_num-second_num;
                break;
            case 3:
                answer = first_num*second_num;
                break;
            case 4:
                answer = first_num/second_num;
                break;
            case 5:
                answer = first_num%second_num;
                break;
        }
        return answer;
    };

    View.OnClickListener calc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!res.equals("")){
                if(first_num == null){
                    first_num = Double.parseDouble(res);
                }else{
                    second_num = Double.parseDouble(res);
                }
            }
            switch (v.getId()){
                case R.id.plus:
                    check =1;
                    break;
                case R.id.sub:
                    check =2;
                    break;
                case R.id.mul:
                    check =3;
                    break;
                case R.id.div:
                    check =4;
                    break;
                case R.id.remain:
                    check =5;
                    break;
                case R.id.clear:
                    set_clear();
                    break;
                case R.id.margin:
                    if(second_num == null && first_num != null){
                        first_num = -(first_num);
                        res = first_num+"";
                    }else if(second_num != null && first_num != null){
                        second_num = -(second_num);
                        res = second_num+"";
                    }
                    tv.setText(res);
                    break;
                case R.id.result:
                    tv.setText(get_result()+"");
                    first_num = get_result();
                    check = -1;
                    second_num = null;
                    break;
            }
            res = "";
        }
    };

    View.OnClickListener num = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn0:
                    res += "0";
                    break;
                case R.id.btn1:
                    res += "1";
                    break;
                case R.id.btn2:
                    res += "2";
                    break;
                case R.id.btn3:
                    res += "3";
                    break;
                case R.id.btn4:
                    res += "4";
                    break;
                case R.id.btn5:
                    res += "5";
                    break;
                case R.id.btn6:
                    res += "6";
                    break;
                case R.id.btn7:
                    res += "7";
                    break;
                case R.id.btn8:
                    res += "8";
                    break;
                case R.id.btn9:
                    res += "9";
                    break;
            }
            tv.setText(res);
        }
    };


}
