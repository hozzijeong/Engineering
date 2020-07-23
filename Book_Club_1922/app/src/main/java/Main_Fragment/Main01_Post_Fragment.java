package Main_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.book_club_1922.R;

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
        

     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.main01_post_fragment,container,false);
        ButterKnife.bind(this,v);
        adapter = new Main01_Post_Adapter(main,arrayList);
        post_lv.setAdapter(adapter);
        return v;
    }
}
