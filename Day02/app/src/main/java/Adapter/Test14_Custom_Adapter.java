package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day02.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Item.Phone_Item;
import Item.Item;

public class Test14_Custom_Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Phone_Item> arrayList;

    public Test14_Custom_Adapter(Context context, ArrayList<Phone_Item> array){
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


        /*
            convertView 가 item_View의 정보들을 받아오는 그릇 같은 느낌.
            만약에 convertView가 null이 아니라면?
         */
        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.activity_test14__item__view,parent,false);
        }

        final Phone_Item curItem = (Phone_Item) getItem(position);

        TextView name = convertView.findViewById(R.id.phone_name_tv);
        TextView num = convertView.findViewById(R.id.phone_num_tv);
        ImageButton call = convertView.findViewById(R.id.call_iv);
        ImageButton msg = convertView.findViewById(R.id.msg_iv);

        name.setText(curItem.getUser_name());
        num.setText(curItem.getUser_num());

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                    전화 버튼을 클릭했을때 일어날 구문
                 */
                Toast.makeText(context,curItem.getUser_name(),Toast.LENGTH_LONG).show();

            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                    msg버튼을 클릭 했을때 일어날 구문
                 */
                Toast.makeText(context,curItem.getUser_name(),Toast.LENGTH_LONG).show();

            }
        });


        return convertView;
    }
}
