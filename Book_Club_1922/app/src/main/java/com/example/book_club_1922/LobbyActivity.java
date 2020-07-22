package com.example.book_club_1922;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import AppHelper.BaseActivity;
import Lobby_Adapter.Guide_Adapter;
import Lobby_Frgment.Lobby01_Splash_Fragment;
import Lobby_Frgment.Lobby02_Guide_Fragment;
import Lobby_Frgment.Lobby03_Login_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LobbyActivity extends BaseActivity implements View.OnClickListener {

    public Lobby01_Splash_Fragment splash_fragment;
    public Lobby02_Guide_Fragment guide_fragment;
    public Lobby03_Login_Fragment login_fragment;
    Guide_Adapter guide_adapter;
    ImageView[] iv = new ImageView[4];
    @BindView(R.id.main_fragment) RelativeLayout main_fragment;
    @BindView(R.id.guide_viewpager) ViewPager guide;
    @BindView(R.id.guide_not_show) Button not_show;
    @BindView(R.id.guide_ok) Button ok;
    @BindView(R.id.guide_widget) RelativeLayout guide_widget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        ButterKnife.bind(this);
        not_show.setOnClickListener(this);
        ok.setOnClickListener(this);
        for(int i=0; i<iv.length; i++){
            iv[i] = findViewById(R.id.process1+i);
        }
        set_Fragment();
        change_fragment(R.id.main_fragment,splash_fragment);
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
    }

    private void timer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int cnt = 0;
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(0);
                    get_log("cnt: "+cnt);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void change_guide(){
        guide_adapter = new Guide_Adapter(fm);
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
                change_guide();
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guide_not_show:
                // 아예 다시보기 x
                break;

            case R.id.guide_ok:
                // 다음번에 어플 시작할때 보여줌
                break;
        }

        guide_widget.setVisibility(View.INVISIBLE);
        main_fragment.setVisibility(View.VISIBLE);
        change_fragment(R.id.main_fragment,login_fragment);
        get_log("guide: "+guide_widget.getVisibility());
    }
}