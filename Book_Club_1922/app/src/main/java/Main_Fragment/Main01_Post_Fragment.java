package Main_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.illguee.book_club_1922.R;

import java.util.ArrayList;

import AppHelper.BaseFragment_Main;
import Main_Adapter.Main01_Post_Adapter;
import Main_Item.Main01_Post_Item;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main01_Post_Fragment extends BaseFragment_Main {

    @BindView(R.id.post_list) ListView post_lv;

    private Main01_Post_Adapter adapter;
    private ArrayList<Main01_Post_Item> arrayList;
    /*
        여기서 어떤 책을 설정하냐에 따라 필터링이 따로 됨.
        Spinner에서 책 구분을 한다면 필터링을 통해, 해당 Fragment의 arrayList에서
        해당 책이 아닌 것은 취급하지 않도록 유도할 것.
        일단 Spinner 처리부터 빨리.... ToolBar 뭐냐구!

        또한, Subject가 추가되어야함. 최종 데이터에서 subject에 add하는 형식으로 추가할 예정.
        하지만, subject의 배열 길이에 따라, 추가되는 Text의 개수가 달라짐. 동적 추가가 필요한 상황.

        어차피 테스트에서 주제개수 늘어나는 것은 상관 없음. 계속해서 늘어나기 때문에, 기존에 저정된 것들만
        불러온다면 상관 없을듯.

        메뉴를 클릭하고 나서, 취소했을때, 클릭 커서가 그 메뉴를 누르기 이전 fragment를 가리키고 있으면 좋겠지만...
        과연...

     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.main01_post_fragment,container,false);
        ButterKnife.bind(this,v);
        arrayList = new ArrayList<>();
        test_array();
        adapter = new Main01_Post_Adapter(main,arrayList);
        post_lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v;
    }

    private void test_array(){
        for(int i=0; i<10; i++){
            arrayList.add(new Main01_Post_Item(
                    "이름","내용","2020-07-24","아몬드",R.drawable.ic_baseline_account_circle_75));
            for (int j=0; j<3; j++){
                arrayList.get(i).subjects.add("주제"+(j+1));
            }
        }
    }

}
