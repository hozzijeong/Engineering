package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn,move;
    TextView tv;

    Boolean turn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        move = findViewById(R.id.move_btn);
        tv = findViewById(R.id.tv);

        move.setOnClickListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn){
            if(turn){
                tv.setText("After");
                turn = false;
            }else{
                tv.setText("Before");
                turn = true;
            }
        }else if(v.getId() == R.id.move_btn){
            Intent intent = new Intent(this,com.example.test01.SubActivity.class);
            startActivity(intent);
        }
    }
}
