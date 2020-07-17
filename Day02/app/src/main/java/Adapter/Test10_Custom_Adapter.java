package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.day02.R;

import java.util.ArrayList;

public class Test10_Custom_Adapter extends ArrayAdapter {
    ArrayList<Test09_Telephone_Item> array;
    Activity activity;
    LayoutInflater lnf;
    public Test10_Custom_Adapter(Activity activity, ArrayList<Test09_Telephone_Item> array){
        super(activity, R.layout.activity_test09__item__view);
        this.array = array;
        this.activity = activity;
        lnf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return array.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return array.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RowHolder viewHolder;

        if(convertView == null){
            convertView = lnf.inflate(R.layout.activity_test09__item__view,parent,false);
            viewHolder = new RowHolder();

            viewHolder.iv = convertView.findViewById(R.id.profile_iv);
            viewHolder.name = convertView.findViewById(R.id.name_tv);
            viewHolder.number = convertView.findViewById(R.id.phone_tv);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (RowHolder) convertView.getTag();
        }


        viewHolder.number.setText(array.get(position).getNumber());
        viewHolder.name.setText(array.get(position).getName());
        viewHolder.iv.setImageResource(array.get(position).getProfile_iv());


        return convertView;
    }

    public class RowHolder{
        ImageView iv;
        TextView name,number;
    }
}
