package history;

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

public class Test08_ListView_Actiivty extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @BindView(R.id.lv) ListView lv;
    @BindView(R.id.add_list) Button add;

    ArrayList<String> arr = new ArrayList<>();
    ArrayAdapter adapter;
    int cnt =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test08__list_view__activity);
        ButterKnife.bind(this);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
        add.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_list:
                    arr.add(cnt+"번째");
                    cnt++;
                    adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        show_toast((position+1)+"번째 List");
    }
}
