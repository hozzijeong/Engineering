package Main_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.book_club_1922.R;

import java.util.ArrayList;

import AppHelper.BaseFragment_Main;
import Main_Adapter.Main01_Post_Adapter;
import Main_Item.Main01_Post_Item;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main02_Create_Fragment extends BaseFragment_Main implements View.OnClickListener {

    @BindView(R.id.create_quite) ImageButton quite;
    @BindView(R.id.create_btn) Button create;
    @BindView(R.id.add_subject) ImageButton add_subject;
    @BindView(R.id.write_book_list) Spinner book_list;
    @BindView(R.id.create_content) EditText content;
    @BindView(R.id.create_subject_layout) LinearLayout subject_layout;

    String book_title;
    ArrayList<EditText> temp_sub = new ArrayList<>();
    ArrayList<String> subs = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.main02_create_fragment,container,false);
        ButterKnife.bind(this,v);

        quite.setOnClickListener(this);
        create.setOnClickListener(this);
        add_subject.setOnClickListener(this);

        book_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                book_title = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_quite:
                setQuite();
                break;

            case R.id.create_btn:
                /*
                    여기서 게시글 정보 업데이트 하고감.
                    책 제목, 내용, 주제들 전부 추가시킴.
                     -> Post통신으로 데이터 저장. 어차피 Item클래스는 껍데기임.
                     subs들을 저장한 테이블 한개를 따로 만들어서 그곳에 모두 저장.
                     Post통신에서 데이터들을 한꺼번에 저장 가능?
                     따로 대용량 저장하는 parms를 만들어서 데이터 송신 해야 할듯.
                     아니 테이블에 그럼 한꺼번에 주루룩 저장이 되나?


                     저장할 것.
                     1. content.gettext.toString
                     2. subs.all
                     3. book_title
                     4. 작성자의 이름
                     5. 날짜 정도?
                 */
                filter();
                setQuite();
                break;

            case R.id.add_subject:
                /*
                    주제 추가하는 메소드. 하지만, 최종적으로 추가하지 않고, 한번 걸렀다가, 저장 눌렀을때
                    최종적으로 추가할 것.
                 */
                EditText sub = new EditText(main);
                sub.setTextSize(13);
                temp_sub.add(sub);
                subject_layout.addView(sub);

                break;
        }
    }

    private void filter(){
        for(int i=0; i<temp_sub.size(); i++){
            if(temp_sub.get(i).getText().toString().trim().length() == 0){
                temp_sub.remove(i);
            }
            subs.add(temp_sub.get(i).getText().toString());
        }
    }

    private void setQuite(){
        main.bt_navi.setVisibility(View.VISIBLE);
        main.top_bar.setVisibility(View.VISIBLE);
        /*
            여기서 navigation 이 가리키는 값이 post가 되도록 설정
         */
        main.change_fragment(R.id.main_layout,main.post_fragment);
        main.quite_fragment(this);
    }
}
