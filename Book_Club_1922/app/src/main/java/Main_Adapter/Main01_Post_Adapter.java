package Main_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.example.book_club_1922.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Main_Item.Main01_Post_Item;

public class Main01_Post_Adapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Main01_Post_Item> arrayList;

    public Main01_Post_Adapter(Context context, ArrayList<Main01_Post_Item> arrayList) {
        super(context, R.layout.main01_post_item);
        this.context = context;
        this.arrayList = arrayList;
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
                    inflate(R.layout.main01_post_item,parent,false);
        }

        Main01_Post_Item curItem = (Main01_Post_Item)getItem(position);

        TextView name_tv = convertView.findViewById(R.id.post_writer);
        TextView date_tv = convertView.findViewById(R.id.write_date);
        TextView title_tv = convertView.findViewById(R.id.book_title);
        TextView  content = convertView.findViewById(R.id.post_content);
        CardView cardView = convertView.findViewById(R.id.post_cardview);

        ImageButton modify_btn = convertView.findViewById(R.id.ud_btn);
        ImageView profile_iv = convertView.findViewById(R.id.post_profile);

        name_tv.setText(arrayList.get(position).getName());
        date_tv.setText(arrayList.get(position).getDate());
        title_tv.setText(arrayList.get(position).getTitle());
        content.setText(arrayList.get(position).getContent());

        profile_iv.setImageResource(arrayList.get(position).getProfile_res());


        modify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        return convertView;
    }
}
