package history;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.day02.R;

import java.util.ArrayList;

import Adapter.Test09_Recycler_Adapter;
import Adapter.Test09_Telephone_Item;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Test09_Recycler_View extends AppCompatActivity implements View.OnClickListener {
    public @BindView(R.id.rv) RecyclerView rv;
    public @BindView(R.id.add_view) Button btn;
    private ArrayList<Test09_Telephone_Item> arr;
    private Test09_Recycler_Adapter adapter;
    private GridLayoutManager grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test09__recycler__view);
        ButterKnife.bind(this);
        grid = new GridLayoutManager(this,2);
        rv.setLayoutManager(grid);

        arr = new ArrayList<>();
        adapter = new Test09_Recycler_Adapter(arr);
        rv.setAdapter(adapter);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_view:
                arr.add(new Test09_Telephone_Item(R.mipmap.ic_launcher_round,"그래","조하"));
                adapter.notifyDataSetChanged();
            break;
        }
    }
}
