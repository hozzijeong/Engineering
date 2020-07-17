package com.example.day02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    protected void show_toast(String data){
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
    }

    protected void change_activity(Context context,Class cls){
        Intent intent = new Intent(context,cls);
        startActivity(intent);
    }

    protected void getLog(String data){
        Log.d("mood",data);
    }

}
