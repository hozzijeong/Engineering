package history;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.day02.BaseActivity;
import com.example.day02.R;

public class Test03_Calc extends BaseActivity {

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
        setContentView(R.layout.activity_test03_calc);

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
        margin.setOnClickListener(special);

        set_clear();
    }

    private void set_clear(){
        res = "";
        turn = false;
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
            if(turn){
                turn = false;
                /*
                    turn의 용도는 계산을 다 하고 난 뒤(= 을 클릭하고 난 뒤), 새로운 계산을 하고 싶을 때,
                    C를 따로 누르지 않고 바로 숫자를 누르면 C가 알아서 되게끔 하도록 설정.
                    계산을 끝낸뒤, 사칙연산자를 눌렀을 경우 turn 을 알아서 false가 되고,
                    이전 계산을 이어서 하게 된다.
                 */

            }

            if(!res.equals("")){
                if(first_num == null){
                    first_num = Double.parseDouble(res);
                }else{
                    second_num = Double.parseDouble(res);
                }
            }
            if(first_num != null && second_num !=null){
                /*
                    사칙 연산의 결과를 보여주는 조건문
                 */
                tv.setText(get_result()+"");
                first_num = get_result();
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
                case R.id.result:
                    check = -1;
                    second_num = null;
                    turn = true;
                    break;
            }
            res = "";
        }
    };


    View.OnClickListener special = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.margin:

                    /*
                        res가 "" 가 아니라는 것은, 사칙연산자를 클릭하지 않고, margin을 클릭했을 때를 의미
                        그게 아니라면, 이미 사칙연산자를 계산 한 뒤 계산을 할 때 +/- 값을 준다면,
                        제일 처음 계산하는 연산자의 기호를 바꿔줌.
                        제일 처음에(first_num = 0.0) 클릭하면 에러가 나기에, null이 아닐때로 설정.
                    */
                    if(!res.equals("")){
                        Double num = Double.parseDouble(res);
                        num = -(num);
                        res = num+"";
                        tv.setText(res);
                    }else{
                        if(first_num != null){
                            first_num = -(first_num);
                            tv.setText(first_num+"");
                        }
                    }
                   break;
            }
        }
    };


    View.OnClickListener num = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(turn){
                set_clear();
            }
            switch (v.getId()){
                case R.id.btn0:
                    if(!res.equals("")){
                        res += "0";
                    }
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
            if(res.equals("")){
                tv.setText("0.0");
            }else{
                tv.setText(res);
            }
        }
    };

}
