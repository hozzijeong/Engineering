package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test09_Recycler_Adapter extends RecyclerView.Adapter<Test09_Recycler_Adapter.CustomViewHolder> {

    private ArrayList<Test09_Telephone_Item> arr;

    public Test09_Recycler_Adapter(ArrayList<Test09_Telephone_Item> arrayList){
        this.arr = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_test09__item__view,parent,false);
       CustomViewHolder holder = new CustomViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {
        holder.iv.setImageResource(arr.get(position).getProfile_iv());
        holder.name.setText(arr.get(position).getName());
        holder.phone.setText(arr.get(position).getNumber());

        holder.itemView.setTag(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"이름: "+holder.name.getText().toString()+
                        "\n번호: "+holder.phone.getText().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arr ?arr.size():0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView name,phone;
        CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv = itemView.findViewById(R.id.profile_iv);
            this.name = itemView.findViewById(R.id.name_tv);
            this.phone = itemView.findViewById(R.id.phone_tv);
        }
    }
}
