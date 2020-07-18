package Adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.day02.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Item.Item;

public class Test13_Custom_Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> arrayList;

    public Test13_Custom_Adapter(Context context, ArrayList<Item> array){
        this.context = context;
        this.arrayList = array;
    }

    @Override
    public int getCount() {
        //Item의 사이즈를 반환시켜 주는 메소드.
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {

        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.activity_test13__item__view,parent,false);
        }

        Item curItem = (Item)getItem(position);

        TextView name_tv = convertView.findViewById(R.id.getname_tv);
        TextView description_tv = convertView.findViewById(R.id.description_tv);

        name_tv.setText(curItem.getItemName());
        description_tv.setText(curItem.getItemDescription());


        return convertView;
    }
}
