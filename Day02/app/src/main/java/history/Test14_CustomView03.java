package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    Test14_Custom_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test14__custom_view03);
        ButterKnife.bind(this);

        adapter = new Test14_Custom_Adapter(this,getList());

        phone_book.setAdapter(adapter);
        total_num.setText("총"+getList().size()+"개의 연락처");
    }

    private ArrayList<Phone_Item> getList(){
        String names[] = getResources().getStringArray(R.array.phone_name);
        String nums[] = getResources().getStringArray(R.array.phone_num);

        ArrayList<Phone_Item> list = new ArrayList<>();
        for(int i=0; i<names.length; i++){
            list.add(new Phone_Item(names[i],nums[i]));
        }
        return list;
    }


}
