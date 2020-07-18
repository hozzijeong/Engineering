package com.example.day02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import history.Test03_Calc;
import history.Test01_Linear_Layout;
import history.Test02_Relative_Layout;
import history.Test04_Frame_Layout;
import history.Test05_Change_Image;
import history.Test06_Count_Activity;
import history.Test07_Handler_Activity;
import history.Test08_ListView_Actiivty;
import history.Test09_Recycler_View;
import history.Test10_CustomListView;
import history.Test11_LifeCycle;
import history.Test12_ListView02;
import history.Test13_CustomListView02;
import history.Test14_CustomView03;

public class MainActivity extends BaseActivity implements View.OnClickListener, OnLongClickListener {
    ArrayList<Button> btn_arr = new ArrayList<>();
    TableLayout table;
    int num =1;

    @BindView(R.id.add_row) Button getAdd_row;
    @BindView(R.id.row1_btn1) Button getBtn1;
    @BindView(R.id.row1_btn2) Button getBtn2;
    @BindView(R.id.row1_btn3) Button getBtn3;
    @BindView(R.id.row1_btn4) Button getBtn4;
    @BindView(R.id.row2_btn1) Button getBtn5;
    @BindView(R.id.row2_btn2) Button getBtn6;
    @BindView(R.id.row2_btn3) Button getBtn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        table = findViewById(R.id.table_layout);
        // 반드시 묶어줘야 하는 부분
        ButterKnife.bind(this);
        connectOnClickListener();
        getAdd_row.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_row:
                set_add_row();
                break;
            case R.id.row1_btn1:
                change_activity(this, Test01_Linear_Layout.class);
                break;
            case R.id.row1_btn2:
                change_activity(this, Test02_Relative_Layout.class);
                break;
            case R.id.row1_btn3:
                change_activity(this, Test03_Calc.class);
                break;
            case R.id.row1_btn4:
                change_activity(this, Test04_Frame_Layout.class);
                break;
            case R.id.row2_btn1:
                change_activity(this, Test05_Change_Image.class);
                break;
            case R.id.row2_btn2:
                change_activity(this, Test06_Count_Activity.class);
                break;
            case R.id.row2_btn3:
                change_activity(this, Test07_Handler_Activity.class);
                break;
            case R.id. row2_btn4:
                change_activity(this, Test08_ListView_Actiivty.class);
                break;
            case R.id. row3_btn1:
                change_activity(this, Test09_Recycler_View.class);
                break;
            case R.id. row3_btn2:
                change_activity(this, Test10_CustomListView.class);
                break;
            case R.id. row3_btn3:
                change_activity(this, Test11_LifeCycle.class);
                break;
            case R.id. row3_btn4:
                change_activity(this, Test12_ListView02.class);
                break;
            case R.id. row4_btn1:
                change_activity(this, Test13_CustomListView02.class);
                break;
            case R.id. row4_btn2:
                change_activity(this, Test14_CustomView03.class);
                break;
            case R.id. row4_btn3:
                change_activity(this, Test11_LifeCycle.class);
                break;
            case R.id. row4_btn4:
                change_activity(this, Test12_ListView02.class);
                break;

        }
    }

    private void set_add_row(){
        /*
            동적으로 추가를 한다고 해도, 데이터 저장이 안되기 때문에 어쩔수 없음.
         */

        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        for (int i=0; i<4; i++){
            Button btn = new Button(this);
            btn_arr.add(btn);
            tableRow.addView(btn);
            btn.setId(R.id.row1_btn4+num);
            num++;
            btn.setOnClickListener(this);
        }
        table.addView(tableRow);
    }

    private void set_btn(){

    }
    /*
       테이블 레이아웃에서 버튼 가져오기
       return List<View>
     */
    public List<View> getAllButtons(ViewGroup layout){
        List<View> viewList = new ArrayList<>();
        for(int i =0; i< layout.getChildCount(); i++){
            View v =layout.getChildAt(i); //해당 테이블로우 전부 가져오기
            viewList.addAll(v.getTouchables()); //해당 테이블로우의 버튼 id 전부 가져오기
        }
        return viewList;
    }
    /*
        view 리스너 연결
     */
    private void connectOnClickListener () {
        Log.d("test","========================= connectOnClickListener =======================");
        List<View> btnList = getAllButtons(table);
        for (View btn:btnList) {
            btn.setOnClickListener(this);
        }
    }


    @Override
    public boolean onLongClick(View v) {

        return false;
    }
}
