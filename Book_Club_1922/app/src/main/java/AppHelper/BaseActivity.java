package AppHelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {
    protected FragmentManager fm;
    protected FragmentTransaction ft;

    protected BaseActivity(){
        this.fm = getSupportFragmentManager();
    }

    protected void show_toast(String data){
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
    }

    protected void get_log(String data){
        Log.d("mood",data);
    }

    public void move_intent(Context context,Class cls){
        Intent intent = new Intent(context,cls);
        startActivity(intent);
    }

    public void save_boolean_preference(String place,String key,boolean data){
        SharedPreferences sp = getSharedPreferences(place,MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putBoolean(key,data);
        editor.commit();
    }

    public Boolean load_boolean_preference(String place,String key){
        SharedPreferences sp = getSharedPreferences(place,MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }

    public void change_fragment(int resource, Fragment fragment){
        // beginTransaction은 fragment가 변경될때 마다 초기화 시켜줘야 한다.
        ft = fm.beginTransaction();
        ft.replace(resource,fragment);
        ft.commit();
    }

    public void quite_fragment(Fragment fragment){
        ft = fm.beginTransaction();
        ft.remove(fragment).commit();
    }


}
