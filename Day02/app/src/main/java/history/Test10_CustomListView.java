package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.day02.BaseActivity;
import com.example.day02.R;

import java.util.ArrayList;

import Adapter.Test09_Telephone_Item;
import Adapter.Test10_Custom_Adapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Test10_CustomListView extends BaseActivity {
    @BindView(R.id.add_list_custom) Button btn;
    @BindView(R.id.customlv) ListView customlv;

    Test10_Custom_Adapter adapter;
    ArrayList<Test09_Telephone_Item> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test10__custom_list_view);
        ButterKnife.bind(this);

        arrayList = new ArrayList<>();
        adapter = new Test10_Custom_Adapter(this,arrayList);
        customlv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(new Test09_Telephone_Item(
                        R.mipmap.ic_launcher_round,"이게","010-0000-0000"));
                adapter.notifyDataSetChanged();
            }
        });

        customlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                show_toast(arrayList.get(position).getNumber());
            }
        });

    }
}
