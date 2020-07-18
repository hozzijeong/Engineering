package history;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.day02.BaseActivity;
import com.example.day02.R;

import java.util.ArrayList;

import Adapter.Test13_Custom_Adapter;
import Item.Item;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Test13_CustomListView02 extends BaseActivity {
    @BindView(R.id.name_lv)
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test13__customlist_view03);

        ButterKnife.bind(this);
        Test13_Custom_Adapter adapter = new Test13_Custom_Adapter(this,getItemList());

        lv.setAdapter(adapter);
    }


    private ArrayList<Item> getItemList(){
        String itemNames[] = getResources().getStringArray(R.array.items_name);
        String itemDescription[] = getResources().getStringArray(R.array.item_description);

        ArrayList<Item> list = new ArrayList<>();

        for(int i=0; i<itemNames.length; i++){
            list.add(new Item(itemNames[i],itemDescription[i]));
        }

        return list;
    }
}
