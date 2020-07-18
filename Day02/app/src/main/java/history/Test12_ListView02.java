package history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.day02.BaseActivity;
import com.example.day02.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test12_ListView02 extends BaseActivity {
    @BindView(R.id.listview) ListView lv;
    @BindView(R.id.add_table) Button add;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    int cnt = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12__list_view02);
        ButterKnife.bind(this);
        arrayList = new ArrayList<>();

        for(int i=0; i<20; i++){
            arrayList.add((i+1)+"번째");
            cnt++;
        }

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                show_toast((position+1)+"번째");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(cnt+"번째");
                adapter.notifyDataSetChanged();
                cnt++;
            }
        });


    }
}
