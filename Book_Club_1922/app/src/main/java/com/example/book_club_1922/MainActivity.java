package com.example.book_club_1922;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import AppHelper.BaseActivity;
import Main_Fragment.Main01_Post_Fragment;
import Main_Fragment.Main02_Alert_Fragment;
import Main_Fragment.Main03_Myinfo_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
        /*
           Main Fragment 구현 해야한다.

           Feed,Create,Custom,Alert 순으로 구현한다.
           Create는 위에서 아래로 올라온느형식 또는 클릭 하면, 따로 화면이 나오는 형식으로 해서 추가되는 방식
           즉, Fragment 사용이 아니라 새로운 위젯 창이 나타나야 한다는 의미

        */
public class MainActivity extends BaseActivity {

    public Main01_Post_Fragment post_fragment;
    public Main02_Alert_Fragment alert_fragment;
    public Main03_Myinfo_Fragment myinfo_fragment;
    @BindView(R.id.main_layout) FrameLayout main_layout;
    @BindView(R.id.bottom_navi) BottomNavigationView bt_navi;
//    @BindView(R.id.top_bar) Toolbar top_bar;
//    @BindView(R.id.book_list) Spinner book_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        set_Fragment();
//        top_bar.setTitle(R.string.myAppName);
//        setSupportActionBar(top_bar);

        change_fragment(R.id.main_layout,post_fragment);
        bt_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.postItem:
                        change_fragment(R.id.main_layout,post_fragment);
                        return true;
                    case R.id.createItem:
                        // post create 만들기
                        return true;

                    case R.id.msgItem:
                        change_fragment(R.id.main_layout,alert_fragment);
                        return true;

                    case R.id.infoItem:
                        change_fragment(R.id.main_layout,myinfo_fragment);
                        return true;

                    default:return false;
                }
            }
        });
    }

    private void set_Fragment(){
        post_fragment = new Main01_Post_Fragment();
        alert_fragment = new Main02_Alert_Fragment();
        myinfo_fragment = new Main03_Myinfo_Fragment();
    }


}