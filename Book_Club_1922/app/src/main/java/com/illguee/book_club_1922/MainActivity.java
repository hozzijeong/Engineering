package com.illguee.book_club_1922;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import AppHelper.BaseActivity;
import Main_Fragment.Main01_Post_Fragment;
import Main_Fragment.Main02_Create_Fragment;
import Main_Fragment.Main03_Alert_Fragment;
import Main_Fragment.Main04_Myinfo_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
        /*
           Main Fragment 구현 해야한다.
           Feed,Create,Custom,Alert 순으로 구현한다.
           Create는 위에서 아래로 올라온느형식 또는 클릭 하면, 따로 화면이 나오는 형식으로 해서 추가되는 방식
           즉, Fragment 사용이 아니라 새로운 위젯 창이 나타나야 한다는 의미
        */
public class MainActivity extends BaseActivity implements View.OnClickListener,
                BottomNavigationView.OnNavigationItemSelectedListener {

    public Main01_Post_Fragment post_fragment;
    public Main02_Create_Fragment create_fragment;
    public Main03_Alert_Fragment alert_fragment;
    public Main04_Myinfo_Fragment myinfo_fragment;
    public @BindView(R.id.main_layout) FrameLayout main_layout;
    public @BindView(R.id.bottom_navi) BottomNavigationView bt_navi;
    public @BindView(R.id.create_layout) FrameLayout create_layout;
    public @BindView(R.id.top_bar) Toolbar top_bar;
    @BindView(R.id.create_btn) ImageButton create_btn;
    @BindView(R.id.select_book) Button select_book;
    @BindView(R.id.drawer) DrawerLayout drawer;
    @BindView(R.id.menu_lv) ListView menu_lv;

    ArrayList<String> bookList = new ArrayList<>();

    /*
        drawer를 열고 닫았을때 bottomnavigation의 위치값을 설정하기 위한 변수들
     */
    int before_id = 0;
    int cur_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        cur_id = R.id.postItem;
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        set_Fragment();
        create_btn.setOnClickListener(this);
        bt_navi.setOnNavigationItemSelectedListener(this);
        change_fragment(R.id.main_layout,post_fragment);
        drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                bt_navi.setSelectedItemId(before_id);
            }
        });
    }

    private void set_Fragment(){
        post_fragment = new Main01_Post_Fragment();
        create_fragment = new Main02_Create_Fragment();
        alert_fragment = new Main03_Alert_Fragment();
        myinfo_fragment = new Main04_Myinfo_Fragment();
    }

    private void setLv(){
        ArrayList<String> menu_component = new ArrayList<>();
        menu_component.add("로그아웃");
        menu_component.add("로그아웃");
        menu_component.add("로그아웃");
        menu_component.add("로그아웃");
        menu_component.add("로그아웃");
        menu_component.add("로그아웃");
        ArrayAdapter adapter =
                new ArrayAdapter(this,android.R.layout.simple_list_item_1,menu_component);
        menu_lv.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_btn:
                create_layout.setVisibility(View.VISIBLE);
                main_layout.setVisibility(View.INVISIBLE);
                top_bar.setVisibility(View.INVISIBLE);
                bt_navi.setVisibility(View.INVISIBLE);
                change_fragment(R.id.create_layout,create_fragment);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        before_id = cur_id;
        cur_id = menuItem.getItemId();
        switch(menuItem.getItemId()){
            case R.id.postItem:
                top_bar.setVisibility(View.VISIBLE);
                change_fragment(R.id.main_layout,post_fragment);
                return true;
            case R.id.msgItem:
                top_bar.setVisibility(View.INVISIBLE);
                change_fragment(R.id.main_layout,alert_fragment);
                return true;
            case R.id.infoItem:
                top_bar.setVisibility(View.INVISIBLE);
                change_fragment(R.id.main_layout,myinfo_fragment);
                return true;
            case R.id.menuItem:
                setLv();
                drawer.openDrawer(GravityCompat.END);
                return true;
            default:return false;
        }
    }
}