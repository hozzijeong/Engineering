package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.day02.R;

import java.util.ArrayList;

import Adapter.Test14_Custom_Adapter;
import Item.Phone_Item;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Test14_CustomView03 extends AppCompatActivity {


    @BindView(R.id.phone_book) ListView phone_book;
    @BindView(R.id.total_num) TextView total_num;
    @BindView(R.id.search_board) EditText search_board;
    Test14_Custom_Adapter adapter;
    ArrayList<Phone_Item> list = new ArrayList<>();
    ArrayList<Phone_Item> temp = new ArrayList<>();
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test14__custom_view03);
        ButterKnife.bind(this);
        getList();
        filter(search_board.getText().toString());
        search_board.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                text = search_board.getText().toString();
                filter(text);
            }
        });

        link_adapter(temp);
    }

    private void getList(){
        String names[] = getResources().getStringArray(R.array.phone_name);
        String nums[] = getResources().getStringArray(R.array.phone_num);
        for(int i=0; i<names.length; i++){
            list.add(new Phone_Item(names[i],nums[i]));
        }
    }

    private void filter(String text){
        temp.clear();
        if(text.length() == 0){
            temp.addAll(list);
        }else{
            for(int i=0; i<list.size(); i++){
                if(list.get(i).getUser_name().contains(text)){
                    temp.add(new Phone_Item(list.get(i).getUser_name(),list.get(i).getUser_num()));
                }
            }
        }
    }


    private void link_adapter(ArrayList<Phone_Item> array){
        adapter = new Test14_Custom_Adapter(this,array);
        phone_book.setAdapter(adapter);
        total_num.setText("총"+array.size()+"개의 연락처");
        adapter.notifyDataSetChanged();
    }

}
