package com.illguee.book_club_1922;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import AppHelper.BaseActivity;
import Lobby_Adapter.Guide_Adapter;
import Lobby_Frgment.Lobby01_Splash_Fragment;
import Lobby_Frgment.Lobby02_Guide_Fragment;
import Lobby_Frgment.Lobby03_Login_Fragment;
import Lobby_Frgment.Lobby04_Join_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LobbyActivity extends BaseActivity implements View.OnClickListener {

    public Lobby01_Splash_Fragment splash_fragment;
    public Lobby02_Guide_Fragment guide_fragment;
    public Lobby03_Login_Fragment login_fragment;
    public Lobby04_Join_Fragment join_fragment;
    Guide_Adapter guide_adapter;
    ImageView[] iv = new ImageView[4];
    Boolean guide_state = false;

    @BindView(R.id.lobby_fragment) FrameLayout main_fragment;
    @BindView(R.id.guide_widget) RelativeLayout guide_widget;
    @BindView(R.id.guide_viewpager) ViewPager guide;
    @BindView(R.id.guide_not_show) Button not_show;
    @BindView(R.id.guide_ok) Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        ButterKnife.bind(this);
        not_show.setOnClickListener(this);
        ok.setOnClickListener(this);
        guide_state = load_boolean_preference("1922","guide_state");

        for(int i=0; i<iv.length; i++){
            iv[i] = findViewById(R.id.process1+i);
        }
        set_Fragment();
        change_fragment(R.id.lobby_fragment,splash_fragment);
        timer();
        guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setMark(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void set_Fragment(){
        splash_fragment = new Lobby01_Splash_Fragment();
        guide_fragment = new Lobby02_Guide_Fragment();
        login_fragment = new Lobby03_Login_Fragment();
        join_fragment = new Lobby04_Join_Fragment();
    }

    private void timer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(0);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void change_guide(){
        guide_adapter = new Guide_Adapter(getSupportFragmentManager());
        guide.setAdapter(guide_adapter);
        guide_widget.setVisibility(View.VISIBLE);
        main_fragment.setVisibility(View.INVISIBLE);
        setMark(0);
    }

    private void setMark(int idx){
        for(int i=0; i<iv.length; i++){
            iv[i].setImageResource(R.drawable.process);
        }
        iv[idx].setImageResource(R.drawable.cur_process);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                if(!guide_state){
                   change_guide();
                }
                change_fragment(R.id.lobby_fragment,login_fragment);
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guide_not_show:
                guide_state = true;
            break;

            case R.id.guide_ok:
                guide_state = false;
                // 다음번에 어플 시작할때 보여줌
                break;
        }
        save_boolean_preference("1922","guide_state",guide_state);
        guide.setVisibility(View.INVISIBLE);
        main_fragment.setVisibility(View.VISIBLE);
        guide_widget.setVisibility(View.INVISIBLE);
    }
}